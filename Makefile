up:
	docker-compose up -d && mvn verify && java -jar target/lock_redis-1.0.0.jar