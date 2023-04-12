#include <Servo.h>
Servo serv1;
Servo serv2;

void setup() {
  Serial.begin(9600);
  // put your setup code here, to run once:
  serv1.attach(3);
  serv2.attach(2);
  //serv1.write(45);
  //serv2.write(135);
  //int pos= 0;
  //delay(1000);

}

void loop() {
  while (Serial.available()){
  String text = Serial.readString();
  Serial.flush();
  char chars[text.length() + 1];
  text.toCharArray(chars, sizeof(chars));
  String spit[2];
  int count = 0;
  for (int i = 0; i < text.length(); i++) {
    if (chars[i] == ' ') {
      spit[0] = text.substring(0, i);
      spit[1] = text.substring(i+1, text.length());
    }
  }
  spit[count] = text;

  int x = spit[0].toInt();
  int y = spit[1].toInt();
  updateBot(x, y);
  //delay(500);
  }

  

  //directions
    //serv1.write(45);
    // range is total 90 degrees, 45 degrees left and 45 degrees right
    // range in input is (0, 90) with 0 as max right and 90 as max left
    //serv2.write(135);  
    // range is total 135 degrees, 45 degress forward, 90 degrees back
    // range in input is (0 max back (45 up, 135 dead forward))
    
}


void updateBot(int x, int y)  {
    double xrat = ((double)x)/((double)600);
    double yrat = ((double)y)/((double)400);

    double servx = abs(90 - (xrat * 90));
    double servy = 45 + (yrat* 180); 
    serv1.write((int)servx);
    serv2.write((int)servy);


}
