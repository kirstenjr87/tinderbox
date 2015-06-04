package models.bot.tasks.message

/**
 * A list of fun, pre-defined message trees.
 */
object RescruitmentMessages {

  def hi=MessageTree( value = "hey {name}, hi!!", right= howareyou, left=sosorry );
  def sosorry=Some(MessageTree( value="I'm so sorry about that, what happen?", right=howareyou, left=None));
  def howareyou=Some(MessageTree( value = "How are you?", right=None, left=None ));
  def hello=MessageTree( value = "Hello {name}!", right=None, left=None );



  //def occhioAzzurro=Occhio(colore="azzrurro");

  //def kirsten=Ruffoni( capelli="blue", occhi=occhioAzzurro, cavallo="Rocky");




  def messages = List( hi, hello);

}
