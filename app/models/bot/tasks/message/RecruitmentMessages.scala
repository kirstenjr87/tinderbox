package models.bot.tasks.message

/**
 * A list of fun, pre-defined message trees.
 */
object RescruitmentMessages {
  def hi=MessageTree( value = "hi!!", right= howareyou, left=None );
  def howareyou=Some(MessageTree( value = "How are you?", right=None, left=None ));


  def hello=MessageTree( value = "Hello!", right=None, left=None );





  def messages = List( hi, hello);

}
