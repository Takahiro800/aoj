package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var ()

func main() {
	H := ReadInt()
	A := ReadIntSlice(H)

	buildMaxHeap(A)
	for i := 0; i < H; i++ {
		fmt.Printf(" %d", A[i])
	}
	fmt.Printf("\n")
}

func maxHeapify(i int, A []int) {
	l := 2*i + 1
	r := 2*i + 2
	biggest := i
	if l < len(A) && A[l] > A[biggest] {
		biggest = l
	}
	if r < len(A) && A[r] > A[biggest] {
		biggest = r
	}

	if biggest != i {
		A[i], A[biggest] = A[biggest], A[i]
		maxHeapify(biggest, A)
	}
}

func parentIndex(i int) int {
	return (i - 1) / 2
}

func buildMaxHeap(arr []int) {
	middle := parentIndex(len(arr) - 1)

	for i := middle; i >= 0; i-- {
		maxHeapify(i, arr)
	}
}

var sc = bufio.NewScanner(os.Stdin)

func init() { sc.Buffer(make([]byte, 256), 1e9); sc.Split(bufio.ScanWords) }

func input() string {
	sc.Scan()
	return sc.Text()
}

func Read() string {
	sc.Scan()
	return sc.Text()
}

func ReadInt() int {
	v, e := strconv.Atoi(Read())
	if e != nil {
		panic(e.Error())
	}
	return v
}

func ReadIntSlice(n int) []int {
	b := make([]int, n)
	for i := 0; i < n; i++ {
		b[i] = ReadInt()
	}
	return b
}
