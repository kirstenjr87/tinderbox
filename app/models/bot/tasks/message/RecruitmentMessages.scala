package models.bot.tasks.message

/**
 * A list of fun, pre-defined message trees.
 */
object RescruitmentMessages {

//exmple of how to do it
  def hi=MessageTree( value = "hey {name}, hi!!", right= howareyou, left=sosorry );
  def sosorry=Some(MessageTree( value="I'm so sorry about that, what happen?", right=howareyou, left=None));
  def howareyou=Some(MessageTree( value = "How are you?", right=None, left=None ));
  def hello=MessageTree( value = "Hello {name}!", right=None, left=None );
  def wherefrom=MessageTree( value= "Where are you from?", right=None, left=None);
  
//set 1
def hi=MessageTree( value= "Hi!", right=howareyou, left=None);
def howareyou=MessageTree( value= "How are you?", right=imfine, left=sosorry);
def imfine=Some(MessageTree( value= "I'm fine too thanks!") right=wherefrom, left=None);
def sosorry=Some(MessageTree( value= "I'm sorry, how come?", right=None, left=None));
def wherefrom=MessageTree( value= "Where are you from?", right=niceplace, left=None);
def niceplace=Some(MessageTree( value= "Nice! I've never been there...what's it like?", right=interesting, left=None));
def interesting=MessageTree( value= "Haha, interesting", right=None, left=None);
def imfrom=MessageTree( value= "I'm from {location} ", right=None, left=None)


  //def occhioAzzurro=Occhio(colore="azzrurro");

  //def kirsten=Ruffoni( capelli="blue", occhi=occhioAzzurro, cavallo="Rocky");




  def messages = List( hi, hello);

}
