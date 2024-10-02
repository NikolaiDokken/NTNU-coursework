#pragma once

#include <iostream>
#include <string>

using namespace std;

double const tax = 0.25;

class Commodity {
  public:
    Commodity(string name_, int id_, double price_);
    string get_name() const;
    int get_id() const;
    double get_price();
    double get_price(double units_);
    void set_price(double price_);
    double get_price_with_sales_tax();
    double get_price_with_sales_tax(double units_);

  private:
    string name;
    int id;
    double price;
};
