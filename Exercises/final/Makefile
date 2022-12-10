# Makefile  
#
#
#     make S22Problem6
#        Makes S22Problem6 executable
#
#     make clean
#        Removes out .o files and executables
#


CXXFLAGS = -ggdb -Wall -std=c++11
OBJS = S22Problem6.o


ectest: $(OBJS)
	$(CXX) $(CXXFLAGS) $(OBJS) -o ectest

clean:
	-rm -f ectest $(OBJS)
