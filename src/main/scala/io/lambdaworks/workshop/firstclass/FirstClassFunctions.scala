package io.lambdaworks.workshop.firstclass

import io.lambdaworks.workshop.firstclass.FirstClassFunctions.EmailType.EmailType

object FirstClassFunctions {

  // Function that sort list of elements based on predicate function(p)
  def sortWith[A](elements: List[A], p: (A, A) => Boolean): List[A] = {
    def sort(elements: List[A]): List[A] =
      if (elements.length <= 1) {
        elements
      } else {
        val pivot = elements(elements.length / 2)

        sort(elements.filter(p(_, pivot))) ++
          elements.filter(_ == pivot) ++
          sort(elements.filter(p(pivot, _)))
      }

    sort(elements)
  }

  type EmailBody = String
  final case class EmailMessage(to: String, body: EmailBody)
  final case class User(email: String, firstName: String, lastName: String)

  object EmailType extends Enumeration {
    type EmailType = Value
    val Welcome, Subscribe, Feedback = Value
  }

  def sendEmail(user: User, emailType: EmailType): EmailMessage =
    EmailMessage(user.email, BuilderFactory.getTemplateBuilder(emailType)(user))

  object BuilderFactory {
    // Function that returns another function
    def getTemplateBuilder(emailType: EmailType): User => EmailBody =
      emailType match {
        case EmailType.Welcome =>
          (u: User) =>
            s"Welcome ${u.firstName} ${u.lastName}, nice to see you!"
        case EmailType.Subscribe =>
          (u: User) =>
            s"Hey ${u.firstName}, you are successfully subscribed!"
        case EmailType.Feedback =>
          (u: User) =>
            s"Hey ${u.firstName}, we received your feedback!"
      }
  }

}
