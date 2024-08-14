import { Employee } from "./employee.js";
import readline from 'readline-sync';
import fs from 'fs';

let employees = [];

let employeeId = readline.questionInt("Enter Employee Id :");
let employeeName = readline.question("Enter Employee name :");
let employeeSalary = readline.questionInt("Enter Employee Salary: ");

let newEmployee = new Employee(employeeId,employeeName,employeeSalary)

if (fs.existsSync("empData.json")) {
    const data = fs.readFileSync("empData.json");
    if (data) {
        employees = JSON.parse(data);
    }
}

employees.push(newEmployee);

const emloyeeJSON = JSON.stringify(employees,null,2);
fs.writeFileSync("empData.json","\n"+emloyeeJSON);
console.log("Data inserted Successfully!");

display();

function display(){
    const data = fs.readFileSync("empData.json");
    if (data) {
        const employees = JSON.parse(data);
        console.log("Employee Data:");
        employees.forEach((employee, index) => {
            console.log(`Employee ${index + 1}:`);
            console.log(`ID: ${employee.id}`);
            console.log(`Name: ${employee.name}`);
            console.log(`Salary: ${employee.salary}`);
            console.log('----------------------');
        });
    } else {
        console.log("No data found in the file.");
    }
}




