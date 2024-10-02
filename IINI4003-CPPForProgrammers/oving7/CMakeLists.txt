cmake_minimum_required(VERSION 2.8)

project(oving79)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++1y -Wall -Wextra")

add_executable(oving79 oppgave2.cpp fraction.cpp set.cpp)
