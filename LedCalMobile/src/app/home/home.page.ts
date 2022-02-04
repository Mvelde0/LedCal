import { Component, OnInit } from '@angular/core';
//import { LedProps } from './vars/LedProps';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {
  constructor() {}

  ngOnInit() {
    console.log('INIT TEST');
    // this.formulaSegment = "1";
  }

  // << Properties >>

  // Input Properties
  input_psupply: number;
  input_pdrop: number;
  input_lcurr: number;
  input_lednum: number;

  // Output Properties
  output_result; // = Output field for calculated resistance
  output_chosen; // = Output field for chosen resistance

  // < Sequence Type Properties >
  formulaSegment; // = ngModel for Formula Segment

  // Result Properties
  _calculatedResistor: number;
  _chosenResistor: number;

  _firstColorLabel: string;
  _secondColorLabel: string;
  _thirdColorLabel: string;

  // << Getter/Setter Properties >>
  private _P_Powersupply: number = 0;
  private _V_Powerdrop: number = 0;
  private _mA_Ledcurrent: number = 0;
  private _Nr_Leds: number = 0;
  private _Seq_Type: number = 0;

  //E12 Values
  _e12val: number[] = [
    0, 0.5, 1.0, 1.2, 1.5, 1.8, 2.2, 2.7, 3.3, 3.9, 4.7, 6.8, 8.2, 10, 10.2,
    10.5, 10.7, 11, 11.3, 11.5, 11.8, 12, 12.1, 12.4, 12.7, 13, 13.3, 13.7, 14,
    14.3, 14.7, 15, 15, 15.4, 15.8, 16.2, 16.5, 16.9, 17.4, 17.8, 18, 18.2,
    18.7, 19.1, 19.6, 20, 20.5, 21, 21.5, 22, 22.1, 22.6, 23.2, 23.7, 24.3,
    24.9, 25.5, 26.1, 26.7, 27, 27.4, 28, 28.7, 29.4, 30.1, 30.9, 31.6, 32.4,
    33, 33.2, 34, 34.8, 35.7, 36.5, 37.4, 38.3, 39, 39.2, 40.2, 41.2, 42.2,
    43.2, 44.2, 45.3, 46.4, 47, 47.5, 48.7, 49.9, 51.1, 52.3, 53.6, 54.9, 56,
    56.2, 57.6, 59, 60.4, 61.9, 63.4, 64.9, 66.5, 68, 68.1, 69.8, 71.5, 73.2,
    75, 76.8, 78.7, 80.6, 82, 82.5, 84.5, 86.6, 88.7, 90.9, 93.1, 95.3, 97.6,
    100, 120, 150, 181, 220, 270, 330, 390, 470, 560, 680, 820, 1000, 1200,
    1800, 2200, 2700, 3300, 3900, 4700, 5600, 6800, 8200, 10000, 12000, 15000,
    18000, 22000, 27000, 33000, 39000, 47000, 56000, 68000, 82000, 1000000,
    1500000, 1800000, 2200000, 2700000, 3300000, 3900000, 4700000,
  ];

  // <<Functions >>

  selectedSegment(e) {
    this.formulaSegment = parseInt(e.detail.value);
    this.SeqType = this.formulaSegment;
  }

  clickButtonCalculate(e) {
    var P = (this.PowerSupply = this.input_psupply);
    var V = (this.PowerDrop = this.input_pdrop);
    var mA = (this.LedCurrent = this.input_lcurr);
    var N = (this.NrLeds = this.input_lednum);

    //TODO: formula is boolean(?)
    var formula = this.SeqType;

    this.fetchValidateParameters(P, V, mA, N, formula);
    this.calculate(P, V, mA, N, formula);
    this.findClosest(this._e12val, this.CalculatedResistor);
    this.convertValues(this.ChosenResistor);
  }

  // If no exception has been thrown during the 'confirmCheck' (WIP) function prior,
  // will calculate the properties based on the sequence type (seqtype) given.

  fetchValidateParameters(
    P: number,
    V: number,
    mA: number,
    N: number,
    seq: number
  ) {
    console.log('Fetching input values.');

    if (P < 3 || P > 24 || P == undefined) {
      throw new Error('Power supply must be between 3 and 24');
    } else if (V < 1.6 || V > 4 || V == undefined) {
      throw new Error('Power Drop must be between 1.6 and 4');
    } else if (mA < 2 || mA > 70 || mA == undefined) {
      throw new Error('Led Current must be between 2 and 70');
    } else if (N < 1 || N > 99 || N == undefined) {
      throw new Error('Number of LEDS must be between 1 and 99');
    } else if (seq == 0) {
      throw new Error('MUST SELECT SEQUENCE (is ' + seq + ')');
    }

    console.log(
      'Got:\n' +
        'Power Supply: ' +
        P +
        ', ' +
        typeof P +
        '\nPower Drop: ' +
        V +
        ', ' +
        typeof V +
        '\nLED Current: ' +
        mA +
        ', ' +
        typeof mA +
        '\nLED Number: ' +
        N +
        ', ' +
        typeof N +
        '\nFormula Type: ' +
        this.SeqType +
        ', ' +
        typeof this.SeqType
    );
  }

  calculate(P, V, mA, N, seq) {
    console.log(
      'Calculating with parameters\n' +
        'Power Supply: ' +
        P +
        ', ' +
        typeof P +
        '\nPower Drop: ' +
        V +
        ', ' +
        typeof V +
        '\nLED Current: ' +
        mA +
        ', ' +
        typeof mA +
        '\nLED Number: ' +
        N +
        ', ' +
        typeof N +
        '\nFormula Type: ' +
        this.SeqType +
        ', ' +
        typeof this.SeqType
    );

    switch (this.SeqType) {
      case 1:
        console.log('Series formula selected');
        this.CalculatedResistor = parseFloat(
          ((P - V * N) / (mA / 1000)).toFixed(2)
        );
        // this.CalculatedResistor.toFixed(2);
        console.log('Calculated result: ' + this.CalculatedResistor);
        this.output_result = 'Ω ' + this.CalculatedResistor;
        break;

      case 2:
        console.log('Parallel formula selected');
        this.CalculatedResistor = parseFloat(
          ((P - V) / ((mA * N) / 1000)).toFixed(2)
        );
        console.log('Calculated result: ' + this.CalculatedResistor);
        this.output_result = 'Ω ' + this.CalculatedResistor;
        break;

      default:
        console.log('CALCULATE: No Formula selected');
        break;
    }
  }

  /*
   * Finds the value of array closest to the target value based on a number of
   * conditions: - If the 'target' is the exact value of an array, it will set
   * that as the new 'chosenResistor' value. - If the 'target' value is higher
   * then that of the value in the array, it will pick the value on the next index
   * and set that as the new 'chosenResistor' value.
   */
  findClosest(arr: number[], target: number) {
    // console.log('List contents: ' + arr + ' \n' + 'TARGETING: ' + target);

    var result: number = 0;

    for (var _i = 0; _i < arr.length; _i++) {
      //     console.log(_i + ' : ' + arr[_i]);

      if (target <= arr[_i]) {
        result = arr[_i];
        // console.log('Chosen Result NOW: ' + result);
        break;
      } else if (arr[_i] <= target) {
        result = arr[_i + 1];
        // console.log('Chosen Result NOW: ' + result);
      }
    }

    this.ChosenResistor = Math.round(result);
    console.log('Chosen result: ' + this.ChosenResistor);
    this.output_chosen = 'Ω ' + this.ChosenResistor;
  }

  /*
   * Will run through the textfields for rangeChecks before continuing to pass the
   * textfield input to the Setters
   */
  convertValues(value: number) {
    var numberToString;
    var newString;

    if (value % 1 != 0) {
      console.log(value + ' contains DECIMALS');
    } else {
      console.log(value + ' contains WHOLE values');
    }
  }

  // Getters & Setters

  public get PowerSupply(): number {
    return this._P_Powersupply;
  }
  public set PowerSupply(psupply: number) {
    this._P_Powersupply = psupply;
    console.log('SETTER: _P_PowerSupply to ' + this.PowerSupply);
  }
  public get PowerDrop(): number {
    return this._V_Powerdrop;
  }
  public set PowerDrop(powerdrop: number) {
    this._V_Powerdrop = powerdrop;
    console.log('SETTER: _V_Powerdrop to ' + this.PowerDrop);
  }
  public get LedCurrent(): number {
    return this._mA_Ledcurrent;
  }
  public set LedCurrent(ledcurrent: number) {
    this._mA_Ledcurrent = ledcurrent;
    console.log('SETTER: _mA_Ledcurrent to ' + this.LedCurrent);
  }
  public get NrLeds(): number {
    return this._Nr_Leds;
  }
  public set NrLeds(nrleds: number) {
    this._Nr_Leds = nrleds;
    console.log('SETTER: _Nr_Leds to ' + this.NrLeds);
  }
  public get SeqType(): number {
    return this._Seq_Type;
  }
  public set SeqType(seqtype: number) {
    this._Seq_Type = seqtype;
    console.log('SETTER: _Seq_Type to ' + this.SeqType);
  }
  public get CalculatedResistor(): number {
    return this._calculatedResistor;
  }
  public set CalculatedResistor(value: number) {
    this._calculatedResistor = value;
  }
  public get ChosenResistor(): number {
    return this._chosenResistor;
  }
  public set ChosenResistor(value: number) {
    this._chosenResistor = value;
  }
}
