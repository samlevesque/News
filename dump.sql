-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: news
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `news` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `description` text,
  `url` varchar(255) DEFAULT NULL,
  `publishedAt` int(11) DEFAULT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'Trump administration recommends against allowing China Mobile access to US market','The Trump administration recommended to the Federal Communications Commission (FCC) on Monday that China Mobile not be allowed to enter the U.S. telecommunications market.','http://thehill.com/policy/technology/395290-trump-administration-recommends-against-allowing-china-mobile-access-to-us',1530584792),(2,'Asian shares falter, China under renewed pressure on trade war fears','Asian shares dropped in tentative morning trade on Tuesday as sentiment remained fragile in the face of tense trade relations between the United States and major economies, with investors braced for another potentially rocky day for Chinese markets.','https://in.reuters.com/article/global-markets/asian-shares-falter-china-under-renewed-pressure-on-trade-war-fears-idINKBN1JT07Y',1530584751),(3,'Oil rises on Libya force majeure, but demand slowdown holds back market','Oil prices climbed on Tuesday after Libya declared force majeure on some of its supplies, although an overall rise in OPEC output and an emerging slowdown in demand held back markets.','https://uk.reuters.com/article/uk-global-oil/oil-rises-on-libya-force-majeure-but-demand-slowdown-holds-back-market-idUKKBN1JT037',1530584601),(4,'NAACP to Starbucks: Don\'t let up on weeding out racial bias','The coffee giant needs to audit stores, update manuals and take other actions in light of the Philadelphia arrests, a report says','https://www.usatoday.com/story/money/business/2018/07/02/starbucks-naacp-keep-attacking-racial-bias/753621002/',1530583560),(5,'Zain Jaffer: criminal abuse charges dropped against former Vungle CEO','A San Mateo, California County judge dismissed felony assault and child abuse charges against Zain Jaffer, who was formerly the founder and CEO of mobile ad firm Vungle. Jaffer was placed on leave …','https://venturebeat.com/2018/07/02/zain-jaffer-criminal-abuse-charges-dropped-against-former-vungle-ceo/',1530576900),(6,'Lyft\'s Big Bike Share Buy Is About Ruling the Streets','The ride-hail company\'s acquisition of Motivate moves it beyond the car—and raises a few questions.','https://www.wired.com/story/lyft-motivate-bike-share-aquisition/',1530576720),(7,'Michael Dell Really Can\'t Lose: How He Transformed A Struggling PC Business Into $30 Billion','Dell\'s simplification push gives glimpse into the coup Michael Dell and Silver Lake have pulled off since taking the once-ailing PC maker private in 2013.','https://www.forbes.com/sites/antoinegara/2018/07/02/michael-dell-really-cant-lose-how-he-transformed-a-struggling-p-c-business-into-30-billion/',1530572156),(8,'Seattle becomes first US city to ban plastic utensils and straws','The city\'s 5,000 restaurants will now have to use reusable or compostable utensils, straws and cocktail picks','https://www.cbsnews.com/news/seattle-becomes-first-u-s-city-to-ban-plastic-utensils-and-straws/',1530571500),(9,'China Has Fallen: Alibaba Is A Conviction Buy','Did you know that BABA is a $484 billion company with a market leader position in e-commerce and cloud computing? This is a company which is well known to Chine','https://seekingalpha.com/article/4185148-china-fallen-alibaba-conviction-buy',1530568146),(10,'Tesla Achieves a Key Weekly Goal for Producing Its Model 3','The automaker said it turned out more than 5,000 of the mass-market sedans last week, a threshold it has said is crucial to reaching profitability.','https://www.nytimes.com/2018/07/02/business/tesla-model-3.html',1530567097),(11,'Wall Street ends higher, helped by tech rally','Wall Street ended higher on Monday after a choppy session, with gains in Apple and other technology stocks offsetting worries about an escalating trade war between Washington and its trading partners.','https://in.reuters.com/article/usa-stocks/wall-street-ends-higher-helped-by-tech-rally-idINKBN1JS1JJ',1530566373),(12,'AT&T/DirecTV Now prices are rising, weeks after Time Warner deal closed','When the Justice Department sued to block AT&T’s merger with Time Warner,  the worry was consumer prices would rise. There may be merit to that argument.','https://www.usatoday.com/story/tech/talkingtech/2018/07/02/some-t-and-directv-now-fees-rising-after-time-warner-merger/752356002/',1530565680),(13,'HTC to lay off 1500 employees','HTC is cutting staff after a long period of bleeding money and market share.','https://money.cnn.com/2018/07/02/technology/htc-layoffs/index.html',1530559992),(14,'Every US-made car is an import. That\'s bad news for automakers','Every car sold in the United States gets a significant percentage of its parts from foreign parts makers. That means auto tariffs could raise prices.','https://money.cnn.com/2018/07/02/news/companies/auto-tariffs/index.html',1530556080),(15,'Sears adds more stores to closings list; 78 set to close in September','Sears Holdings list of closing locations is growing. Now, 62 Sears and 16 Kmart stores are expected to close in September.','https://www.usatoday.com/story/money/nation-now/2018/07/02/sears-closings-78-kmart-and-sears-closing-september/750127002/',1530550420),(16,'Whole Foods\' Prime discounts let Amazon ask its most important question to customers in person','Whole Foods\' Prime discounts have rolled out nationwide, which means Amazon now has a new, in-person avenue to hawk Prime memberships to shoppers.','http://www.businessinsider.com/amazon-prime-boost-from-whole-foods-stores-2018-7',1530548877),(17,'Someone bought $1 million in Toys \'R\' Us toys right before stores went out of business','An anonymous shopper gave Toys \'R\' Us a parting gift just before its stores around the country prepared to close their doors for the last time.','http://www.nbc-2.com/story/38556223/someone-bought-1-million-in-toys-r-us-toys-right-before-stores-went-out-of-business',1530544260),(18,'Nestlé in Talks to Buy Pet-Food Maker for $2 Billion','Nestlé is in talks to acquire a majority stake in Canada’s Champion Petfoods for more than $2 billion, as it boosts investment in higher-growth businesses to offset packaged-foods operations.','https://www.wsj.com/articles/nestle-in-talks-to-buy-pet-food-maker-for-2-billion-1530531553',1530533340),(19,'Bell-Boeing JV Wins $4.2B Deal to Manufacture V-22 Variants','Bell-Boeing  will involve in the manufacture and delivery of 39 CMV-22B aircraft for the U.S. Navy; 34 MV-22B aircraft for U.S. Marine Corps; 1 CV-22B for the U. S. Air Force; and 4 MV-22B aircraft for the government of Japan.','https://www.zacks.com/stock/news/309951/BellBoeing-JV-Wins-42B-Deal-to-Manufacture-V22-Variants',1530533257),(20,'Juul closing in on $16B valuation','E-cigarette maker Juul is raising $1.2 billion at a valuation of more than $16 billion, per Bloomberg. Reports of a funding round emerged a couple weeks ago, when The Information reported that the...','https://pitchbook.com/newsletter/juul-closing-in-on-16b-valuation-qhM',1530522387);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-03  0:24:06
