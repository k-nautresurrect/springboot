var Studentdb=require('../models/model');

exports.create=(req,res)=>{
if(!req.body)
{
    res.status(400).send({message:"Ivalid Input field"});
    return;
}
const student=new Studentdb({
    name:req.body.name,
    rollno:req.body.rollno,
    dateofbirth:req.body.dateofbirth,
    marks:req.body.marks
})
student.save(student).then(data=>{
   // res.send(data)
   res.redirect('/add-student')
}).catch(err=>{
    res.status(500).send({message:err.message||"Some error"});
});
}

exports.update=(req,res)=>{
    if(!req.body){
        return res
            .status(400)
            .send({ message : "Data to update can not be empty"})
    }
    const id = req.params.id;
    Studentdb.findByIdAndUpdate(id, req.body, { useFindAndModify: false})
        .then(data => {
            if(!data){
                res.status(404).send({ message : `Cannot Update user with ${id}. Maybe user not found!`})
            }else{
                res.send(data)
            }
        })
        .catch(err =>{
            res.status(500).send({ message : "Error Update user information"})
        })
}
exports.delete=(req,res)=>{
    const id = req.params.id;

    Studentdb.findByIdAndDelete(id)
        .then(data => {
            if(!data){
                res.status(404).send({ message : `Cannot Delete with id ${id}. Maybe id is wrong`})
            }else{
                res.send({
                    message : "User was deleted successfully!"
                })
            }
        })
        .catch(err =>{
            res.status(500).send({
                message: "Could not delete User with id=" + id
            });
        });
}

exports.find=(req,res)=>{
    if(req.query.id){
        const id = req.query.id;

        Studentdb.findById(id)
            .then(data =>{
                if(!data){
                    res.status(404).send({ message : "Not found user with id "+ id})
                }else{
                    res.send(data)
                }
            })
            .catch(err =>{
                res.status(500).send({ message: "Erro retrieving user with id " + id})
            })

    }else{
    Studentdb.find().then(student=>{
        res.send(student)
    })
    .catch(err=>{
        res.status(500).send({message:err.message||"Someting is Wrong"})
    })}

}
exports.search= async (req,res)=>{
    //const { rollno, dateofbirth } = req.body;
    const sturollno = req.body.rollno;



    try {
        console.log(sturollno +" TTTTTTTTT");
        const student= await Studentdb.findOne({ rollno:sturollno });
  
      if (student) {
        const sanitizedStudent = {
            name: student.name,
            rollNumber: student.rollno,
            dateOfBirth: student.dateofbirth,
            marks: student.marks,
          };

      //  res.send(sanitizedStudent);
       res.render('result',  { student : sanitizedStudent});
      } else {
        res.render("studentview", {
            error : "Login with correct roll number"
          })
      }
    } catch (error) {
      console.error(error);
      res.status(500).send('Error searching for student');
    }
}