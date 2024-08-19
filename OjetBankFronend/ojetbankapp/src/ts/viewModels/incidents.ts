/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as AccUtils from "../accUtils";
import ko = require("knockout");
import "oj-c/input-number";
import "oj-c/input-text";
import "ojs/ojknockout";
import "oj-c/button";
import 'oj-c/input-password';
import "oj-c/form-layout"

class IncidentsViewModel {

  firstname: ko.Observable<string> | ko.Observable<any>; 
  lastname:ko.Observable<any>;
  address1: ko.Observable<string> | ko.Observable<any>; 
  address2: ko.Observable<string> | ko.Observable<any>; 
  address3: ko.Observable<string> | ko.Observable<any>; 
  city: ko.Observable<string> | ko.Observable<any>; 
  state: ko.Observable<string> | ko.Observable<any>; 
  zip: ko.Observable<string> | ko.Observable<any>; 
  phone: ko.Observable<string> | ko.Observable<any>; 
  email: ko.Observable<string> | ko.Observable<any>; 


  public buttonAction = async(event:Event)=>{
      

    const data = {
      first_name: this.firstname(),
      last_name: this.lastname(),
      address1: this.address1(),
      address2: this.address2(),
      address3: this.address3(),
      city: this.city(),
      state: this.state(),
      zip: this.zip(),
      phone: this.phone(),
      email: this.email()
    }

    console.log(data);


    fetch('http://localhost:8080/obank/newregistration', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(result => {
      console.log(result);
      if(result && result.customerId){
        sessionStorage.setItem('id', result.customerId);
        alert('Registration Successfull!');
      }
      else{
        alert("Something went wrong, Try Again.")
      }
 
    })
    .catch(error => {
      console.error('Error:', error);
      alert('An error occurred while registering');
    });
    return true;
 
    
  }


  constructor() {
    this.firstname = ko.observable(null);
    this.lastname = ko.observable(null);
    this.address1 = ko.observable(null);
    this.address2 = ko.observable(null);
    this.address3 = ko.observable(null);
    this.city = ko.observable(null);
    this.state = ko.observable(null);
    this.zip = ko.observable(null);
    this.phone = ko.observable(null);
    this.email = ko.observable(null);



  }

} 

export = IncidentsViewModel;
