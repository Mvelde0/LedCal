export class LedProps {
  // CURRENTLY NOT IN USE

  // << Input Properties >>

  // Number Range
  // - Power Supply (P) = 3 - 24
  // - Power Drop (V) = 1.6 - 4
  // - LED Current (mA) = 2 - 70
  // - Number of LEDS = 1 - 99

  private _P_Powersupply: number;
  private _V_Powerdrop: number;
  private _mA_Ledcurrent: number;
  private _Nr_Leds: number;

  // Sequence Type
  private _formulaType: number;

  // << Result Properties >>
  private _calculatedResistor: number;
  private _chosenResistor: number;

  private _firstColorLabel;
  private _secondColorLabel;
  private _thirdColorLabel;

  //E12 Values
  private _e12val = [
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

  constructor() {}

  // < Getters & Setters>

  public get PowerSupply() {
    return this._P_Powersupply;
  }

  public setPowerSupply(powersupply: number) {
    // if (powersupply < 3 || powersupply > 24) {
    //   throw new Error('Power supply must be between 3 and 24');
    // }
    this._P_Powersupply = powersupply;
  }
  public getPowerDrop() {
    return this._V_Powerdrop;
  }

  public setPowerDrop(powerdrop: number) {
    // if (powerdrop < 1.6 || powerdrop > 4) {
    //   throw new Error('Power Drop must be between 1.6 and 4');
    // }
    this._V_Powerdrop = powerdrop;
  }

  public getLedCurrent() {
    return this._mA_Ledcurrent;
  }

  public setLedCurrent(ledcurrent: number) {
    // if (ledcurrent < 2 || ledcurrent > 70) {
    //   throw new Error('Led Current must be between 2 and 70');
    // }
    this._mA_Ledcurrent = ledcurrent;
  }

  public getNrLeds() {
    return this._Nr_Leds;
  }

  public setNrLeds(nrleds: number) {
    // if (nrleds < 1 || nrleds > 99) {
    //   throw new Error('Number of LEDS must be between 1 and 99');
    // }
    this._Nr_Leds = nrleds;
  }

  public getFormulaType() {
    return this._formulaType;
  }

  public setFormulatype(formulatype: number) {
    // if (formulatype < 0 || formulatype > 2) {
    //   throw new Error('Formula Type must be either 1 or 2');
    // }
    this._formulaType = formulatype;
  }

  public getCalculatedResistor() {
    return this._calculatedResistor;
  }

  public setCalculatedResistor(resultResistor: number) {
    this._calculatedResistor = resultResistor;
  }

  public getChosenResistor() {
    return this._chosenResistor;
  }

  public setChosenResistor(chosenResistor: number) {
    this._chosenResistor = chosenResistor;
  }

  public getE12Values() {
    return this._e12val;
  }
}
