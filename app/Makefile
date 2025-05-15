APP_NAME := app

.PHONY: build run-dist run clean

build:
	@echo "Building the project..."
	./gradlew installDist

run-dist: build
	@echo "Running distribution..."
	./build/install/app/bin/${APP_NAME}

run:
	@echo "Running the app..."
	./gradlew run

clean:
	@echo "Cleaning..."
	./gradlew clean
