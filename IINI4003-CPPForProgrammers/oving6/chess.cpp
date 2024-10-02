#include <iostream>
#include <memory>
#include <stdlib.h>
#include <string>
#include <vector>

using namespace std;

class ChessBoard {
public:
  enum class Color { WHITE, BLACK };

  class Piece {
  public:
    Color color;

    Piece(Color color) : color(color) {}
    virtual ~Piece() {}


    string color_string() const {
      if (color == Color::WHITE)
        return "white";
      else
        return "black";
    }

    /// Return color and type of the chess piece
    virtual string type() const = 0;

    /// Returns true if the given chess piece move is valid
    virtual bool valid_move(int from_x, int from_y, int to_x, int to_y) const = 0;

    virtual string shortName() const = 0;
  };

  class King : public Piece {
  public:
    King(Color color) : Piece(color){};
    ~King(){};

    string type() const override {
      return color_string() + " king";
    }

    bool valid_move(int from_x, int from_y, int to_x, int to_y) const override {
      return (abs(to_x - from_x) <= 1 && abs(to_y - from_y) <= 1);
    }

    string shortName() const override {
      if (color_string() == "white") {
        return "W-Ki";
      } else {
        return "B-Ki";
      }
    }
  };

  class Knight : public Piece {
  public:
    Knight(Color color) : Piece(color){};
    ~Knight(){};

    string type() const override {
      return color_string() + " knight";
    }

    bool valid_move(int from_x, int from_y, int to_x, int to_y) const override {
      if ((abs(to_x - from_x) == 2 && abs(to_y - from_y) == 1) || (abs(to_x - from_x) == 1 && abs(to_y - from_y) == 2)) {
        return true;
      } else {
        return false;
      }
    }

    string shortName() const override {
      if (color_string() == "white") {
        return "W-Kn";
      } else {
        return "B-Kn";
      }
    }
  };

  ChessBoard() {
    // Initialize the squares stored in 8 columns and 8 rows:
    squares.resize(8);
    for (auto &square_column : squares)
      square_column.resize(8);
  }

  /// 8x8 squares occupied by 1 or 0 chess pieces
  vector<vector<unique_ptr<Piece>>> squares;
  function<void()> after_piece_move;


  /// Move a chess piece if it is a valid move.
  /// Does not test for check or checkmate.
  bool move_piece(const std::string &from, const std::string &to) {
    int from_x = from[0] - 'a';
    int from_y = stoi(string() + from[1]) - 1;
    int to_x = to[0] - 'a';
    int to_y = stoi(string() + to[1]) - 1;

    auto &piece_from = squares[from_x][from_y];
    if (piece_from) {
      if (piece_from->valid_move(from_x, from_y, to_x, to_y)) {
        cout << piece_from->type() << " is moving from " << from << " to " << to << endl;
        auto &piece_to = squares[to_x][to_y];
        if (piece_to) {
          if (piece_from->color != piece_to->color) {
            cout << piece_to->type() << " is being removed from " << to << endl;
            if (auto king = dynamic_cast<King *>(piece_to.get()))
              cout << king->color_string() << " lost the game" << endl;
          } else {
            // piece in the from square has the same color as the piece in the to square
            cout << "can not move " << piece_from->type() << " from " << from << " to " << to << endl;
            return false;
          }
        }
        piece_to = move(piece_from);
        if (after_piece_move) {
          after_piece_move();
        }
        return true;
      } else {
        cout << "can not move " << piece_from->type() << " from " << from << " to " << to << endl;
        return false;
      }
    } else {
      cout << "no piece at " << from << endl;
      return false;
    }
  }
};

class ChessBoardPrint {
public:
  ChessBoardPrint(ChessBoard &board) {
    board.after_piece_move = [&board]() {
      for (int i = 0; i < 8; i++) {
        cout << "------------------------------------------" << endl;
        for (int j = 0; j < 8; j++) {
          cout << "|";
          auto &piece_from = board.squares[j][i];
          if (piece_from) {
            cout << piece_from->shortName();
          } else {
            cout << "    ";
          }
        }
        cout << "|" << endl;
      }
      cout << "------------------------------------------" << endl << endl;
    };
  }
};

int main() {
  ChessBoard board;
  ChessBoardPrint print(board);

  board.squares[4][0] = make_unique<ChessBoard::King>(ChessBoard::Color::WHITE);
  board.squares[1][0] = make_unique<ChessBoard::Knight>(ChessBoard::Color::WHITE);
  board.squares[6][0] = make_unique<ChessBoard::Knight>(ChessBoard::Color::WHITE);

  board.squares[4][7] = make_unique<ChessBoard::King>(ChessBoard::Color::BLACK);
  board.squares[1][7] = make_unique<ChessBoard::Knight>(ChessBoard::Color::BLACK);
  board.squares[6][7] = make_unique<ChessBoard::Knight>(ChessBoard::Color::BLACK);

  cout << "Invalid moves:" << endl;
  board.move_piece("e3", "e2");
  board.move_piece("e1", "e3");
  board.move_piece("b1", "b2");
  cout << endl;

  cout << "A simulated game:" << endl;
  board.move_piece("e1", "e2");
  board.move_piece("g8", "h6");
  board.move_piece("b1", "c3");
  board.move_piece("h6", "g8");
  board.move_piece("c3", "d5");
  board.move_piece("g8", "h6");
  board.move_piece("d5", "f6");
  board.move_piece("h6", "g8");
  board.move_piece("f6", "e8");
}
