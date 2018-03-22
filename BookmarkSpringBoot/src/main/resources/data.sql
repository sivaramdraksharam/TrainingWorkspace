insert into Users (id,firstName,lastName,password,gender,email,userType) values(1000,'test','John','john@123','MALE' ,'user0@semanticsquare.com','USER')
insert into Users (id,firstName,lastName,password,gender,email,userType) values(1001,'mahi','bhai','mahi@123','MALE' ,'msd@gmail.com','USER')


insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (4000,'Walden','https://images.gr-assets.com/books/1475850110l/31425208.jpg','unknown',0,0)
insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (4001,'Self-Reliance and Other Essays','https://images-na.ssl-images-amazon.com/images/I/41HgrBGzwTL._SX331_BO1,204,203,200_.jpg','unknown',0,0)
insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (4002,'Light From Many Lamps','https://images.gr-assets.com/books/1347739312l/1270698.jpg','unknown',0,0)
insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (4003,'Head First Design Patterns','https://images-na.ssl-images-amazon.com/images/I/51PqAvdWZCL._SX258_BO1,204,203,200_.jpg','unknown',0,0)
insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (4004,'Effective Java Programming Language Guide','https://images-na.ssl-images-amazon.com/images/I/515NAEG8MJL._SX258_BO1,204,203,200_.jpg','unknown',0,0)
insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (3000,'Citizen Kane','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGAfTkfO34jZDTDrWUWRc8S1Ndu54vEynuuDS9k5igUaXjR7CC','unknown',0,0)
insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (3001,'The Grapes of Wrath','https://upload.wikimedia.org/wikipedia/en/thumb/1/1f/JohnSteinbeck_TheGrapesOfWrath.jpg/200px-JohnSteinbeck_TheGrapesOfWrath.jpg','unknown',0,0)
insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (3002,'A Touch of Greatness','https://images-na.ssl-images-amazon.com/images/M/MV5BMTI5Mjk3MDE2MF5BMl5BanBnXkFtZTcwNzU1MTgyMQ@@._V1_UY268_CR10,0,182,268_AL_.jpg','unknown',0,0)
insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (3003,'The Big Bang Theory', 'https://upload.wikimedia.org/wikipedia/en/7/7b/The_Big_Bang_Theory_%28Official_Title_Card%29.png','unknown',0,0)
insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (3004,'Ikiru','https://images-na.ssl-images-amazon.com/images/I/81yVROr1dXL._SL1500_.jpg','unknown',0,0)
insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (2000,'Use Final Liberally','','unknown',0,0)
insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (2001,'How do I import a pre-existing Java project into Eclipse and get up and running?','','unknown',0,0)
insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (2002,'Interface vs Abstract Class','','unknown',0,0)
insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (2003,'NIO tutorial by Greg Travis', '','unknown',0,0)
insert into Bookmark   (id,title,profileurl,kidfriendlystatus,kidfriendlymarkedby, sharedbyuser) values   (2004,'Virtual Hosting and Tomcat','','unknown',0,0)


insert into Books   (id,publicationyear,publisher,author,genre,amazonrating) values   (4000,1854,'Wilder Publications','Henry David Thoreau','PHILOSOPHY',4.3)
insert into Books   (id,publicationyear,publisher,author,genre,amazonrating) values   (4001,1993,'Dover Publications','Ralph Waldo,Emerson','PHILOSOPHY',4.5)
insert into Books   (id,publicationyear,publisher,author,genre,amazonrating) values   (4002,1988,'Touchstone','Lillian Eichler Watson','PHILOSOPHY',5.0)
insert into Books   (id,publicationyear,publisher,author,genre,amazonrating) values   (4003,2004,'O Reilly Media','Eric Freeman,Bert Bates,Kathy Sierra,Elisabeth Robson','TECHNICAL',4.5)
insert into Books   (id,publicationyear,publisher,author,genre,amazonrating) values   (4004,2007,'Prentice Hall','Joshua Bloch','TECHNICAL',4.9)

insert  into Movies (id,releaseYear,cast,directors,genre,imdbRating) values (3000,1941,'Orson Welles,Joseph','Cotten Orson Welles','CLASSICS',8.5)
insert  into Movies (id,releaseYear,cast,directors,genre,imdbRating) values (3001,1940,'Henry Fonda,Jane Darwell','John Ford','CLASSICS',8.2)
insert  into Movies (id,releaseYear,cast,directors,genre,imdbRating) values (3002,2004,'Albert Cullum','Leslie Sullivan','DOCUMENTARIES',7.3)
insert  into Movies (id,releaseYear,cast,directors,genre,imdbRating) values (3003,2007, 'Kaley Cuoco,Jim Parsons', 'Chuck Lorre,Bill Prady','TV_SHOWS', 8.7)
insert  into Movies (id,releaseYear,cast,directors,genre,imdbRating) values (3004,1952,'Takashi Shimura,Minoru Chiaki','Akira Kurosawa','FOREIGN_MOVIES',8.4)

insert into Weblinks (id,url,host) values(2000,'http://www.javapractices.com/topic/TopicAction.do?Id=23','http://www.javapractices.com')
insert into Weblinks (id,url,host) values(2001,'https://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running','http://www.stackoverflow.com')
insert into Weblinks (id,url,host) values(2002,'http://mindprod.com/jgloss/interfacevsabstract.html','http://tomcat.apache.org')
insert into Weblinks (id,url,host) values(2003,'http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf','http://cs.brown.edu')
insert into Weblinks (id,url,host) values(2004,'http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html','http://tomcat.apache.org')

