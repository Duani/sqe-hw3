/* @provengo summon selenium */
TEACHER_USERNAME = "teacher"
TEACHER_PASSWORD = "sandBox1#"
ADMIN_USERNAME = "admin"
ADMIN_PASSWORD = "Ah*yaWTF1"
COURSE_NAME = "My first course"
/**
 * This story opens a new browser window, goes to google.com, and searches for a pizza.
 */
story('Teacher upload file to forum', function () {
 
  let s = new SeleniumSession().start('http://localhost:80');
 
  s.goToLogin({username: TEACHER_USERNAME, password: TEACHER_PASSWORD})
  s.myCourseTab()
 
  s.goToCourse()
  s.enterForum()
  s.addDiscussionTopic({header:"Just For Testing", body:"I am just testing"});
 
  // s.logoutAndCheck()
})


/**
 * This story opens a new browser window, goes to google.com, and searches for a pizza using the "I Feel Lucky" feature.
 */
story('Admin changing the File uploading size', function () {
  // the "with" statement makes it redundant to write "s." before each call to a defined event (like the story above)
  let s = new SeleniumSession().start('http://localhost/')
  s.goToLogin({username:ADMIN_USERNAME, password:ADMIN_PASSWORD})
  s.myCourseTab()
  // s.goToCourse({course:COURSE_NAME})
  s.goToCourse()
  s.enterForumAdmin()
  s.changeFileSizeAdmin()
  // s.logoutAndCheck()
})


