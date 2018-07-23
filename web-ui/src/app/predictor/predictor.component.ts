import { Component, OnInit } from '@angular/core';
import { MlService } from '../ml.service';
import { PredictPara } from '../PredictPara'

@Component({
  selector: 'app-predictor',
  templateUrl: './predictor.component.html',
  styleUrls: ['./predictor.component.css']
})
export class PredictorComponent implements OnInit {

  predictResult: string;
  caseDescription: string;
  predictInfo: PredictPara;

  constructor(private mlService: MlService) { 
    
  }

  ngOnInit() {
    this.caseDescription = "";
    this.predictResult = "initial";
    this.predictInfo = {
      Info:"",
      Modelid:11,
      Category:""
    }
  }

  getPredict(): void {
    this.predictResult = null;
    this.predictInfo.Info = this.caseDescription;
    this.predictInfo.Modelid = 1;

    // this.mlService.getPredict(this.caseDescription).subscribe(result =>
    //   this.predictResult = result
    //   //console.info(result)
    // );

    //console.info(this.predictInfo);
    this.mlService.startPredict(this.predictInfo).subscribe(result =>
      //console.info(result)
      this.predictResult = result.Category
      //this.predictResult = result;
    )
    //this.mlService.startPredict(this.predictInfo);
  }
}
