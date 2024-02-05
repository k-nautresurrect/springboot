const express=require('express');
const route=express.Router();
const axios=require('axios');

const controller=require('../controller/controller');



route.get('/teacherview',(req,res)=>{
    axios.get('http://localhost:5000/api/student').then
    (function(response){
        console.log(response);
        res.render('teacherview',{student:response.data});////for temp add teacher view then later change it//
    }).catch(err=>{
        res.send(err);
    })
})
route.get('/add-student',(req,res)=>{
    res.render('add_student');
})
route.get('/update-student',(req,res)=>{
    axios.get('http://localhost:5000/api/student', { params : { id : req.query.id }})
    .then(function(studentdata){
        console.log(studentdata)
        res.render("update_student", { student : studentdata.data})
    })
    .catch(err =>{
        res.send(err);
    })
   // res.render('update_student');
})
route.get('/',(req,res)=>{
    res.render('index');
})
route.get('/studentview',(req,res)=>{
    res.render('studentview')
})



route.post('/api/student',controller.create)
route.post('/api/student_search',controller.search)
route.get('/api/student',controller.find)
//route.get('/api/student',controller.search)
route.put('/api/student/:id',controller.update)
route.delete('/api/student/:id',controller.delete)


module.exports=route;
