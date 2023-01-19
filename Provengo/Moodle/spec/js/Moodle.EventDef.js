/* @Provengo summon selenium */

// goToLogin
defineEvent(SeleniumSession, "goToLogin", function(session, e){
  session.click("/html/body/div[2]/nav/div[2]/div/div/span/a");

  session.writeText("/html/body/div[2]/div[2]/div/div/section/div/div/div/div/form[1]/div[1]/input", e.username)
  session.writeText("/html/body/div[2]/div[2]/div/div/section/div/div/div/div/form[1]/div[2]/input", e.password)

  session.click("/html/body/div[2]/div[2]/div/div/section/div/div/div/div/form[1]/div[3]/button")
  
})

// goingt to my course tab
defineEvent(SeleniumSession, "myCourseTab", function(session, e){
  session.click("/html/body/div[3]/nav/div[1]/nav/ul/li[3]/a")
})

// Enterig to forum with admin
defineEvent(SeleniumSession, "enterForumAdmin", function(session, e) {
  session.click("//*[@id='module-1']/div/div[1]/div/div[1]/div/div[2]/div[2]/a")
})

// Change file size by admin
defineEvent(SeleniumSession, "changeFileSizeAdmin", function(session, e) {
  // Click the "Settings" button
  session.click("/html/body/div[3]/div[4]/div/div[2]/nav/ul/li[2]/a")

  // Click the "Attachment and word counts" button
  session.click("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/form/fieldset[3]/div[1]/div/a")

  // session.click("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/form/fieldset[3]/div[2]/div[1]/div[2]/select")

  // Find the drop-down list element
  session.click("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/form/fieldset[3]/div[2]/div[1]/div[2]/select")
  
  // Select the desired value from the drop-down list
  session.click("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/form/fieldset[3]/div[2]/div[1]/div[2]/select/option[11]")

  // Click the "save and return to course" button
  session.click("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/form/div[4]/div[2]/fieldset/div/div[1]/span/input")

});

// Enter Forum
defineEvent(SeleniumSession, "enterForum", function(session, e) {
  session.click("//*[@id='module-1']/div/div[1]/div/div[1]/div/div[2]/div[2]/a");
});

// goToCourse
defineEvent(SeleniumSession, "goToCourse", function(session, e){
  session.click("/html/body/div[3]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/a/span[3]")
})

// check if we upload files
// defineEvent(SeleniumSession, 'checkForUploadFileMessage', function(session, e) {
//   // check for the message that the file has been uploaded
//   const message = session.getText('//*[@id="content"]/div[2]/div[1]');
//   if (message !== 'File uploaded') {
//       throw new Error('File was not uploaded');
//   }
// })

// add discussion topic
defineEvent(SeleniumSession, 'logoutAndCheck', function(session, e){
  // locate and click on 'add discussion topic'
  session.click("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/div[1]/div/div[2]/a");

  // enter the subject name
  session.writeText("//*[@id='id_subject']", e.subject);
  // enter the message content
  session.writeText("//*[@id='id_messageeditable']", e.message);

  

})

defineEvent(SeleniumSession, "addDiscussionTopic", function(session, e){
  // locate and click on 'add discussion topic'
  session.click("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/div[1]/div/div[2]/a");
  // enter the subject name
  session.writeText("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/div[2]/div[2]/form/div[2]/div[2]/input", e.header);
  // enter the message content
  session.writeText("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/div[1]/div/div[3]/div", e.body);
  
    // upload a new file
  // Click the "Advanced" button
  session.click("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/div[2]/div[2]/form/div[4]/div[2]/fieldset/div/div[3]/span/input");

  // Find the file upload field and click on it
  session.click("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/form/fieldset[1]/div[2]/div[4]/div[2]/fieldset/div/div[2]/div[1]/div[1]/div[1]/a")
  // let fileInput = document.evaluate("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/form/fieldset[1]/div[2]/div[4]/div[2]/fieldset/div/div[2]/div[1]/div[1]/div[1]/a", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
  // fileInput.removeAttribute("hidden");
  // fileInput.click();
  session.click("/html/body/div[10]/div[3]/div/div[2]/div/div/div[1]/div[7]/a")

  session.writeText("/html/body/div[10]/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div/div/form/div/div[1]/input", "Matilda")

  session.click("/html/body/div[10]/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div/div/form/p/button")

  session.click("/html/body/div[10]/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/a[1]/div[1]/div[3]")

  session.click("/html/body/div[11]/div[3]/div/div[2]/div/div[2]/form/div[4]/div/button[1]")

  session.sleep(1000)

  session.click("/html/body/div[4]/div[4]/div/div[3]/div/section/div[2]/form/div[3]/div[2]/fieldset/div/div[1]/span/input")

  session.assertText("/html/body/div[3]/div[4]/div/div[3]/div/section/span[1]/div/p[1]", "Your post was successfully added.\n" + "\n" + "You have 30 mins to edit it if you want to make any changes.")
})
