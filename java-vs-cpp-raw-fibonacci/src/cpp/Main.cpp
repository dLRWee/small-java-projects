#include <iostream>
#include <string>

#define PRINTLN(MESSAGE) std::cout << MESSAGE << std::endl

long fibonacci(int index);

int main(int argc, const char* argv[])
{
	int index = std::stoi(argv[1]);
	long fibo = fibonacci(index);
	PRINTLN(fibo);
}

long fibonacci(int index)
{
	if (index == 0 || index == 1)
	{
		return 1L;
	}

	return fibonacci(index - 2) + fibonacci(index - 1);
}
