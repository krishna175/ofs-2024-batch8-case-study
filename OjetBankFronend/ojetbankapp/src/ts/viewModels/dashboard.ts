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
import 'oj-c/input-password';
import "oj-c/input-date-text";
import "ojs/ojknockout";
import "ojs/ojformlayout";
import "oj-c/button";
import 'oj-c/message-banner';
import "oj-c/progress-bar";

class DashboardViewModel {

    username: ko.Observable<string> | ko.Observable<any>; 
    password:ko.Observable<any>;


    public buttonAction = async(event:Event)=>{
      

      const data = {
        username: this.username(),
        password: this.password()
      }

      console.log(data);


      fetch('http://localhost:8080/obank/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      })
      .then(response => response.json())
      .then(result => {
        console.log(result);
        sessionStorage.setItem('id', result);
        if(result==0){
          alert('Invalid Credentials')
        }
        else{
        alert('Login Successful');
        window.location.href = "?ojr=welcome";
        }
      })
      .catch(error => {
        console.error('Error:', error);
        alert('An error occurred while Login');
      });
      return true;
   
      
    }

    constructor() {
      this.username = ko.observable(null);
      this.password = ko.observable(null);

    }



}

export = DashboardViewModel;


