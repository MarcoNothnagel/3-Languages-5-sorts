#include <bits/stdc++.h>
#include <chrono>
#include <iostream>
#include <fstream>

using namespace std;
using namespace std::chrono;

string bubble[4] = {"Bubble Sort", "", "", ""};
string merges[4] = {"Merge Sort", "", "", ""};
string insertion[4] = {"Insertion Sort", "", "", ""};
string shell[4] = {"Shell Sort", "", "", ""};
string selection[4] = {"Selection Sort", "", "", ""};

// Time Complexity: O(n^2)
void bubbleSort(int arr[], int n)
{
    int i, j;
    for (i = 0; i < n - 1; i++)
        for (j = 0; j < n - i - 1; j++)
            if (arr[j] > arr[j + 1])
                swap(arr[j], arr[j + 1]);
}

// Time Complexity: O(n log(n))
void merge(int array[], int const left, int const mid,
           int const right)
{
    auto const subArrayOne = mid - left + 1;
    auto const subArrayTwo = right - mid;

    // Create temp arrays
    auto *leftArray = new int[subArrayOne],
         *rightArray = new int[subArrayTwo];

    // Copy data to temp arrays leftArray[] and rightArray[]
    for (auto i = 0; i < subArrayOne; i++)
        leftArray[i] = array[left + i];
    for (auto j = 0; j < subArrayTwo; j++)
        rightArray[j] = array[mid + 1 + j];

    auto indexOfSubArrayOne = 0,   // Initial index of first sub-array
        indexOfSubArrayTwo = 0;    // Initial index of second sub-array
    int indexOfMergedArray = left; // Initial index of merged array

    // Merge the temp arrays back into array[left..right]
    while (indexOfSubArrayOne < subArrayOne && indexOfSubArrayTwo < subArrayTwo)
    {
        if (leftArray[indexOfSubArrayOne] <= rightArray[indexOfSubArrayTwo])
        {
            array[indexOfMergedArray] = leftArray[indexOfSubArrayOne];
            indexOfSubArrayOne++;
        }
        else
        {
            array[indexOfMergedArray] = rightArray[indexOfSubArrayTwo];
            indexOfSubArrayTwo++;
        }
        indexOfMergedArray++;
    }

    // Copy the remaining elements of left[]
    while (indexOfSubArrayOne < subArrayOne)
    {
        array[indexOfMergedArray] = leftArray[indexOfSubArrayOne];
        indexOfSubArrayOne++;
        indexOfMergedArray++;
    }

    // Copy the remaining elements of right[]
    while (indexOfSubArrayTwo < subArrayTwo)
    {
        array[indexOfMergedArray] = rightArray[indexOfSubArrayTwo];
        indexOfSubArrayTwo++;
        indexOfMergedArray++;
    }
    delete[] leftArray;
    delete[] rightArray;
}

// begin is for left index and end is
// right index of the sub-array
// of arr to be sorted */
void mergeSort(int array[], int const begin, int const end)
{
    if (begin >= end)
        return; // Returns recursively

    auto mid = begin + (end - begin) / 2;
    mergeSort(array, begin, mid);
    mergeSort(array, mid + 1, end);
    merge(array, begin, mid, end);
}

void insertionSort(int arr[], int n)
{
    int i, a, j;
    for (i = 1; i < n; i++)
    {
        a = arr[i];
        j = i - 1;
        while (j >= 0 && a < arr[j])
        {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = a;
    }
}

void shellSort(int arr[], int n)
{
    int gap = floor(n / 2);
    while (gap > 0)
    {
        int j = gap;
        while (j < n)
        {
            int i = j - gap;
            while (i >= 0)
            {
                if (arr[i + gap] > arr[i])
                {
                    break;
                }
                else
                {
                    arr[i + gap], arr[i] = arr[i], arr[i + gap];
                }
                i = i - gap;
            }
            j = j + 1;
        }
        gap = floor(gap / 2);
    }
}

void selectionSort(int arr[], int n)
{
    int i, j, min;
    for (i = 0; i < n - 1; i++)
    {
        min = i;
        for (j = i + 1; j < n; j++)
            if (arr[j] < arr[min])
                min = j;
        if (min != i)
        {
            arr[min], arr[i] = arr[i], arr[min];
        }
    }
}

void runsmall()
{
    int unsortedList[100];
    int size = sizeof(unsortedList) / sizeof(unsortedList[0]);
    int i;
    for (int i = 0; i < size; i++)
    {
        unsortedList[i] = (rand() % 101);
    }

    auto starta = high_resolution_clock::now();
    bubbleSort(unsortedList, size);
    auto stopa = high_resolution_clock::now();
    auto durationa = duration_cast<nanoseconds>(stopa - starta);
    cout << "Bubble Sort: \n";
    float timer = durationa.count();
    timer = timer / 1000000;
    bubble[1] = to_string(timer);
    cout << timer << endl;

    auto startb = high_resolution_clock::now();
    mergeSort(unsortedList, 0, size - 1);
    auto stopb = high_resolution_clock::now();
    auto durationb = duration_cast<nanoseconds>(stopb - startb);
    cout << "Merge Sort: \n";
    timer = durationb.count();
    timer = timer / 1000000;
    merges[1] = to_string(timer);
    cout << timer << endl;

    auto startc = high_resolution_clock::now();
    insertionSort(unsortedList, size);
    auto stopc = high_resolution_clock::now();
    auto durationc = duration_cast<nanoseconds>(stopc - startc);
    cout << "Insertion Sort: \n";
    timer = durationc.count();
    timer = timer / 1000000;
    if (timer <= 0.001)
    {
        timer = 0.001;
    }
    insertion[1] = to_string(timer);
    cout << timer << endl;

    auto startd = high_resolution_clock::now();
    shellSort(unsortedList, size);
    auto stopd = high_resolution_clock::now();
    auto durationd = duration_cast<nanoseconds>(stopd - startd);
    cout << "Shell Sort: \n";
    timer = durationd.count();
    timer = timer / 1000000;
    shell[1] = to_string(timer);
    cout << timer << endl;

    auto starte = high_resolution_clock::now();
    selectionSort(unsortedList, size);
    auto stope = high_resolution_clock::now();
    auto duratione = duration_cast<nanoseconds>(stope - starte);
    cout << "Selection Sort: \n";
    timer = duratione.count();
    timer = timer / 1000000;
    selection[1] = to_string(timer);
    cout << timer << endl;
}

void runmedium()
{
    int unsortedList[1000];
    int size = sizeof(unsortedList) / sizeof(unsortedList[0]);
    int i;
    for (int i = 0; i < size; i++)
    {
        unsortedList[i] = (rand() % 101);
    }

    auto starta = high_resolution_clock::now();
    bubbleSort(unsortedList, size);
    auto stopa = high_resolution_clock::now();
    auto durationa = duration_cast<nanoseconds>(stopa - starta);
    cout << "Bubble Sort: \n";
    float timer = durationa.count();
    timer = timer / 1000000;
    bubble[2] = to_string(timer);
    cout << timer << endl;

    auto startb = high_resolution_clock::now();
    mergeSort(unsortedList, 0, size - 1);
    auto stopb = high_resolution_clock::now();
    auto durationb = duration_cast<nanoseconds>(stopb - startb);
    cout << "Merge Sort: \n";
    timer = durationb.count();
    timer = timer / 1000000;
    merges[2] = to_string(timer);
    cout << timer << endl;

    auto startc = high_resolution_clock::now();
    insertionSort(unsortedList, size);
    auto stopc = high_resolution_clock::now();
    auto durationc = duration_cast<nanoseconds>(stopc - startc);
    cout << "Insertion Sort: \n";
    timer = durationc.count();
    timer = timer / 1000000;
    insertion[2] = to_string(timer);
    cout << timer << endl;

    auto startd = high_resolution_clock::now();
    shellSort(unsortedList, size);
    auto stopd = high_resolution_clock::now();
    auto durationd = duration_cast<nanoseconds>(stopd - startd);
    cout << "Shell Sort: \n";
    timer = durationd.count();
    timer = timer / 1000000;
    shell[2] = to_string(timer);
    cout << timer << endl;

    auto starte = high_resolution_clock::now();
    selectionSort(unsortedList, size);
    auto stope = high_resolution_clock::now();
    auto duratione = duration_cast<nanoseconds>(stope - starte);
    cout << "Selection Sort: \n";
    timer = duratione.count();
    timer = timer / 1000000;
    selection[2] = to_string(timer);
    cout << timer << endl;
}

void runlarge()
{
    int unsortedList[10000];
    int size = sizeof(unsortedList) / sizeof(unsortedList[0]);
    int i;
    for (int i = 0; i < size; i++)
    {
        unsortedList[i] = (rand() % 101);
    }

    auto starta = high_resolution_clock::now();
    bubbleSort(unsortedList, size);
    auto stopa = high_resolution_clock::now();
    auto durationa = duration_cast<nanoseconds>(stopa - starta);
    cout << "Bubble Sort: \n";
    float timer = durationa.count();
    timer = timer / 1000000;
    bubble[3] = to_string(timer);
    cout << timer << endl;

    auto startb = high_resolution_clock::now();
    mergeSort(unsortedList, 0, size - 1);
    auto stopb = high_resolution_clock::now();
    auto durationb = duration_cast<nanoseconds>(stopb - startb);
    cout << "Merge Sort: \n";
    timer = durationb.count();
    timer = timer / 1000000;
    merges[3] = to_string(timer);
    cout << timer << endl;

    auto startc = high_resolution_clock::now();
    insertionSort(unsortedList, size);
    auto stopc = high_resolution_clock::now();
    auto durationc = duration_cast<nanoseconds>(stopc - startc);
    cout << "Insertion Sort: \n";
    timer = durationc.count();
    timer = timer / 1000000;
    insertion[3] = to_string(timer);
    cout << timer << endl;

    auto startd = high_resolution_clock::now();
    shellSort(unsortedList, size);
    auto stopd = high_resolution_clock::now();
    auto durationd = duration_cast<nanoseconds>(stopd - startd);
    cout << "Shell Sort: \n";
    timer = durationd.count();
    timer = timer / 1000000;
    shell[3] = to_string(timer);
    cout << timer << endl;

    auto starte = high_resolution_clock::now();
    selectionSort(unsortedList, size);
    auto stope = high_resolution_clock::now();
    auto duratione = duration_cast<nanoseconds>(stope - starte);
    cout << "Selection Sort: \n";
    timer = duratione.count();
    timer = timer / 1000000;
    selection[3] = to_string(timer);
    cout << timer << endl;
}

string convertToString(string *a, int size)
{
    int i;
    string s = "";
    for (i = 0; i < size; i++)
    {
        s = s + a[i];
        s = s + "/";
    }
    return s;
}

int main()
{
    cout << "Small: \n";
    runsmall();
    cout << "\n \nMedium: \n";
    runmedium();
    cout << "\n \nLarge: \n";
    runlarge();

    string bubbleStats = convertToString(bubble, 4);
    string mergeStats = convertToString(merges, 4);
    string insertionStats = convertToString(insertion, 4);
    string shellStats = convertToString(shell, 4);
    string selectionStats = convertToString(selection, 4);

    ofstream MyFile("cppfile.txt");
    if (MyFile.is_open())
    {
        MyFile << bubbleStats << endl;
        MyFile << mergeStats << endl;
        MyFile << insertionStats << endl;
        MyFile << shellStats << endl;
        MyFile << selectionStats;

        MyFile.close();
    }
    else
        cout << "Unable to open file";

    return 0;
}
