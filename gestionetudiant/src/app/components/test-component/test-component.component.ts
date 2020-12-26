import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-test-component',
  templateUrl: './test-component.component.html',
  styleUrls: ['./test-component.component.css']
})
export class TestComponentComponent implements OnInit,OnChanges {
  values;
    tests=[];
  changes=[];
  constructor() { }

  ngOnInit(): void {
  }

  onKey(value) {
    if(value)
    {
      this.tests.push(value);
    }


  }
  ngOnChanges(changes: SimpleChanges) {
    // tslint:disable-next-line:forin

      /*
      const chng=changes[propName];
      const  cur=JSON.stringify(chng.currentValue);
      const prev=JSON.stringify(chng.previousValue);
      this.changes.push(`${propName}: currentValue = ${cur}, previousValue = ${prev}`)*/
      // tslint:disable-next-line:no-console
      console.log(changes)

  }
}
