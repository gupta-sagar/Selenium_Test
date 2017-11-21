# SELENIUM Testing

We will help test out a survey hosting site, http://checkbox.io

We will write unit tests using Selenium that verify the following:
http://checkbox.io/studies.html

* The participant count of "Frustration of Software Developers" is 55
* The total number of studies closed is 5.
* If a status of a study is open, you can click on a "Participate" button.
* Check if the "Software Changes Survey" has a Amazon reward image.

**Solution**

1. The participant count of "Frustration of Software Developers" is 55  
   Logic:  
   1. Search for the span containing text "Frustration of Software Developers".
   2. Go to the parent of parent of this span.
   3. Go to "span4" class which has "backers" class span.
   4. Check if the text in this span is "55".  

2. The total number of studies closed is 5.  
   Logic:  
   1. Find all the "status" classes of `a` tag.
   2. From these make a list of all the spans that contains text "CLOSED".
   3. Check if the list size is 5.  
   
3. If a status of a study is open, you can click on a "Participate" button.  
   Logic:  
   1. Find all the "status" classes of `a` tag.
   2. Find all the spans that contains text "OPEN".
   3. Go to parent of parent of these spans.
   4. From these make a list of all button elements of button class "btn btn-info".
   5. For each button, check if it is enabled. 

4. Check if the "Software Changes Survey" has a Amazon reward image.  
   Logic:  
   1. Find the span conatining text "Software Changes Survey".
   2. Go to the parent of parent of this span.
   3. Go to div class "award".
   4. Find `img` tag in this division.
   5. Check if the image source of this tag is the Amazon Award Image source by checking it's reference to http://www.checkbox.io/media/amazongc-micro.jpg.  
   
The code for the above unit tests can be found in `Selenium/src/test/java/selenium/tests/WebTest.java`.  

To Run the code:  
   1. Import Selenium project.
   2. Run WebTest.java to see the test cases running.
