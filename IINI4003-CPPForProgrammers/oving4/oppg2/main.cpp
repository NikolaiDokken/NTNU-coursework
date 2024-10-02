#include <gtkmm.h>

class Window : public Gtk::Window {
public:
  Gtk::VBox vbox;
  Gtk::Label labelFirstName;
  Gtk::Label labelLastName;
  Gtk::Entry entryFirstName;
  Gtk::Entry entryLastName;
  Gtk::Button button;
  Gtk::Label labelCombined;

  Window() {
    button.set_label("Combine names");
    labelFirstName.set_label("First Name");
    labelLastName.set_label("Last Name");
    button.set_sensitive(false);

    vbox.pack_start(labelFirstName);
    vbox.pack_start(entryFirstName); //Add the widget entry to vbox
    vbox.pack_start(labelLastName);
    vbox.pack_start(entryLastName); //Add the widget entry to vbox
    vbox.pack_start(button);        //Add the widget button to vbox
    vbox.pack_start(labelCombined); //Add the widget label to vbox

    add(vbox);  //Add vbox to window
    show_all(); //Show all widgets

    entryFirstName.signal_changed().connect([this]() {
      if (entryFirstName.get_text().length() > 0 && entryLastName.get_text().length() > 0) {
        button.set_sensitive(true);
      } else {
        button.set_sensitive(false);
      }
    });

    entryLastName.signal_changed().connect([this]() {
      if (entryFirstName.get_text().length() > 0 && entryLastName.get_text().length() > 0) {
        button.set_sensitive(true);
      } else {
        button.set_sensitive(false);
      }
    });

    button.signal_clicked().connect([this]() {
      labelCombined.set_text(entryFirstName.get_text() + " " + entryLastName.get_text());
    });
  }
};

int main() {
  Gtk::Main gtk_main;
  Window window;
  window.property_title() = "Oving4";
  gtk_main.run(window);
}
