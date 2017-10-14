drop table favoriteSportTbl if exists;


create table favoriteSportTbl (primaryId integer identity primary key, kuOnlineId varchar(100) not null, favoriteSport varchar(100) not null );

