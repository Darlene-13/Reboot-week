#include <stdio.h>
#include <Arduino.h>


// This is the main file for the communication module of the project.
// It initializes the communication interfaces and handles data transmission and reception.

// PIN DEFINITIONS
const int PIN_PRESSURE = 34;
const int PIN_DISPLACEMENT = 35;
const int PIN_LED_GREEN = 25;
const int PIN_LED_YELLOW = 26;
const int PIN_LED_RED = 27;
const int PIN_BUZZER = 32;

// Enum of alert levels
enum AlertLevel {
    SAFE,
    WARNING,
    DANGER
};


// Safety thresholds in float
const float THRESHOLD_PRESSURE_WARNING = 24.0;
const float THRESHOLD_PRESSURE_DANGER = 28.0;
const float THRESHOLD_DISPLACEMENT_WARNING = 5.0;
const float THRESHOLD_DISPLACEMENT_DANGER = 10.0;

//Current sensor readings
float currentPressure = 0.0;
float currentDisplacement = 0.0;

// Current alert level
AlertLevel currentAlert = SAFE;


void setup(){
    // Initialize serial communication for debugging
    Serial.begin(115200);

    // Initialize sensor_pins
    pinMode(PIN_PRESSURE, INPUT);
    pinMode(PIN_DISPLACEMENT, INPUT);
    
    // Initialize output pins
    pinMode(PIN_LED_GREEN, OUTPUT);
    pinMode(PIN_LED_YELLOW, OUTPUT);
    pinMode(PIN_LED_RED, OUTPUT);
    pinMode(PIN_BUZZER, OUTPUT);

    Serial.println("Communication module initialized.");
}


// Method to evaluate thresholds
void evaluateThresholds(){
    if(currentPressure >= THRESHOLD_PRESSURE_DANGER || currentDisplacement >= THRESHOLD_DISPLACEMENT_DANGER){
        currentAlert = DANGER;
    
    } else if (currentPressure >= THRESHOLD_PRESSURE_WARNING || currentDisplacement >= THRESHOLD_DISPLACEMENT_WARNING){
        currentAlert = WARNING;
    
    } else {
        currentAlert = SAFE;
    }
}


// Method to update LED states based on alert level
void updateLeds(){
    // Turn of all of them at first
    digitalWrite(PIN_LED_GREEN, LOW);
    digitalWrite(PIN_LED_YELLOW, LOW);
    digitalWrite(PIN_LED_RED, LOW);
    digitalWrite(PIN_BUZZER, LOW);

    // Turn on the right LED and buzzer based on the alert level
    if (currentAlert == DANGER){
        digitalWrite(PIN_LED_RED, HIGH);
        digitalWrite(PIN_BUZZER, HIGH);
    }else if (currentAlert == WARNING){
        digitalWrite(PIN_LED_YELLOW, HIGH);
    }else {
        digitalWrite(PIN_LED_GREEN, HIGH);
    }
}

void printStatus() {
  Serial.println("===============================================");
  Serial.print("Pressure:    "); Serial.print(currentPressure);    Serial.println(" MPa");
  Serial.print("Convergence: "); Serial.print(currentDisplacement); Serial.println(" mm");
  Serial.print("Alert:       ");
  if (currentAlert == DANGER)       Serial.println("DANGER!!! ");
  else if (currentAlert == WARNING) Serial.println("WARNING!!");
  else                              Serial.println("SAFE.");
}


// Process loop
void loop(){

    // Read sensor values
    int rawPressure = analogRead(PIN_PRESSURE);
    int rawDisplacement = analogRead(PIN_DISPLACEMENT);
    //Convert to real units
    currentPressure = (rawPressure / 4095.0) * 30.0; 
    currentDisplacement = (rawDisplacement / 4095.0) * 50.0; 
    
    //Determine alert level based on thresholds
    evaluateThresholds();

    // Update outputs based on the alert level
    updateLeds();

    // For debugging: print current sensor values and alert level
    printStatus();

    delay(1000); // Delay for a while before the next reading

}