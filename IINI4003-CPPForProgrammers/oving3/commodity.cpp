#include <iostream>
#include <string>
#include "commodity.hpp"

using namespace std;
// ==> Implementasjon av klassen Circle

Commodity::Commodity(string name_, int id_, double price_) : name(name_), id(id_), price(price_) {};

string Commodity::get_name() const {
  return name;
}

int Commodity::get_id() const {
  return id;
}

double Commodity::get_price() {
  return price;
}

double Commodity::get_price(double units_) {
  return price*units_;
}

void Commodity::set_price(double price_) {
  price = price_;
}

double Commodity::get_price_with_sales_tax() {
  double price_with_sales_tax = tax * price + price;
  return price_with_sales_tax;
}

double Commodity::get_price_with_sales_tax(double units_) {
  double price_with_sales_tax = tax * price + price;
  return price_with_sales_tax * units_;
}
