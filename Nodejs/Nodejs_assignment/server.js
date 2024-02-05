const express=require('express');
const dotenv=require('dotenv');
const morgan=require('morgan');
const bodyparser=require('body-parser');
const path=require('path');

const app=express();

const connectDB=require('./server/database/connection');

dotenv.config({path:'config.env'});
const PORT=process.env.PORT||8080

app.use(morgan('tiny'));

connectDB();



app.use(bodyparser.urlencoded({extended:true}))


app.set("view engine","ejs")
//app.set("views",path.resolve(__dirname,))

app.use('/css', express.static(path.resolve(__dirname, "assets/css")))
app.use('/js', express.static(path.resolve(__dirname, "assets/js")))

app.use('/',require('./server/routes/router'))

// app.get('/',(req,res)=>{
//     res.render('teacherview');////for temp add teacher view then later change it//
// })
// app.get('/add-student',(req,res)=>{
//     res.render('add_student');
// })
// app.get('/update-student',(req,res)=>{
//     res.render('update_student');
// })

app.listen(PORT,()=>{console.log(`Server is running http://localhost:${PORT}`)});