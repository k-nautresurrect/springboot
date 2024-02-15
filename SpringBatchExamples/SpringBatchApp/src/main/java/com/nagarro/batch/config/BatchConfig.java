package com.nagarro.batch.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.batch.domain.Customer;
import com.nagarro.batch.repository.CustomerRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    //CSV Reader
    @Bean
    public FlatFileItemReader<Customer> customerReader() {
        FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
        itemReader.setName("csv-reader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    private LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "firstName", "lastName", "gender", "company", "occupation");
        BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Customer.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    //CSVPROCESSOR
    @Bean
    public CustomerProcessor customerProcessor() {
        return new CustomerProcessor();
    }

    @Bean
    public RepositoryItemWriter<Customer> customerWriter() {
        RepositoryItemWriter<Customer> repositoryWriter = new RepositoryItemWriter<>();
        repositoryWriter.setRepository(customerRepo);
        repositoryWriter.setMethodName("save");

        return repositoryWriter;
    }

    @Bean
    public JsonFileItemWriter<Customer> jsonFileItemWriter() {
        JacksonJsonObjectMarshaller<Customer> marshaller = new JacksonJsonObjectMarshaller<>();
        JsonFileItemWriter<Customer> writer = new JsonFileItemWriter<>(new FileSystemResource("src/main/resources/output.json"), marshaller);
        writer.setAppendAllowed(true); // Set to true if you want to append to an existing file
        return writer;
    }

    //step
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step-1").<Customer, Customer>chunk(10)
                .reader(customerReader())
                .processor(customerProcessor())
                .writer(jsonFileItemWriter()).build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step-2").<Customer, Customer>chunk(10)
                .reader(customerReader())
                .processor(customerProcessor())
                .writer(customerWriter()).build();
    }

    @Bean
    public Job job() {
        return jobBuilderFactory.get("customers-job")
                .start(step1())
                .next(step2())
                .build();

    }

}
