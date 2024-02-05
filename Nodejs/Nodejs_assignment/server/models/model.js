const mongoose=require('mongoose')

var schema=new mongoose.Schema({
    name : {
        type : String,
        required: true
    },
    rollno : {
        type: Number,
        required: true,
        unique: true
    },
    dateofbirth : {
        type: String,
        required: true,
      //  unique: true
    },
    marks : {
        type: Number,
        required: true,
       // unique: true
    },
   
})
const Studentdb = mongoose.model('studentdb', schema);

module.exports = Studentdb;