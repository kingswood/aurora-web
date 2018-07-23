import { Component, OnInit } from '@angular/core';
import { MlService } from '../ml.service';

@Component({
  selector: 'app-statastics',
  templateUrl: './statastics.component.html',
  styleUrls: ['./statastics.component.css']
})

export class StatasticsComponent implements OnInit {
  pietype: string;
  piedata: {};
  pieoptions: {};

  bartype: string;
  bardata: {};
  baroptions: {};
  selectedFile = null;

  constructor(private mlService: MlService) { }

  ngOnInit() {
    this.drawpie();
    this.drawbar(); 
  }

  drawpie() {
    this.pietype = 'pie';
    this.piedata = {
      labels: ["Parma", "User", "Renault", "PSW", "Email"],
      datasets: [
        {
          label: "Last Training Information",
          data: [65,  80, 81, 55, 40]
        }
      ]
    };
    this.pieoptions = {
      responsive: true,
      maintainAspectRatio: false
    };
  }

  drawbar() {
    this.bartype = 'bar';
    this.bardata = {
      labels: ["Training Data", "Accurate Data", "Error Data"],
      datasets: [
        {
          label: "Last Training Information",
          data: [25000, 22000, 3000]
        }
      ]
    };
    this.baroptions = {
      responsive: true,
      maintainAspectRatio: false
    };
  }

  onPicked(event){
    console.log(event);

    this.selectedFile = event.target.files[0];
  }

  trainmodel(){
    console.log(123);
    console.log(this.selectedFile);
    this.mlService.startTraining(this.selectedFile);

    
  }
}
