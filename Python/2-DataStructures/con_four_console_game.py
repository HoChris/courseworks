"""
This module shows users a Connect Four game.

Attributes:
    PLAYER1 (char): player symbol on the board game
    PLAYER2 (char):player symbol on the board game
"""
PLAYER1 = 'R'
PLAYER2 = 'B'


class Connect4:
    """
    The game class.

    Attributes:
        column (int): number of Columns
        row (int): number of Rows
        data {list): store the data of the board
    """
    def __init__(self, column=7, row=6):
        """
        Arguments:
            column (int): number of Columns
            row (int): number of Rows
            data {list): store the data of the board
        """
        self.column = column
        self.row = row
        self.data = []
        for row in range(self.row):
            board_row = []
            for col in range(self.column):
                board_row += ['.']
            self.data += [board_row]

    def print_current(self):
        """
        Prints the current state of the Board and player pieces

        Returns:
            Prints the board to the console
        """
        print_board = ''
        for row in range(self.row):
            print_board += ' '
            for col in range(self.column):
                print_board += self.data[row][col] + ' '
            print_board += '\n'
        print_board += '--' * self.column + '\n'
        for col in range(self.column):
            print_board += ' ' + str(col % 10)
        print_board += '\n'
        return print(print_board)

    def add_move(self, column, player):
        """
        Allows player to input a game piece into the board
        and check for valid column number

        Arguments:
            column (int): selects the column
            player (char): sets what piece on the board

        Returns:

        """
        if self.allows_move(column):
            for row in range(self.row):
                if self.data[row][column] != '.':
                    self.data[row-1][column] = player
                    self.check_win(player)
                    return
            self.data[self.row-1][column] = player
        else: return

    def allows_move(self, column):
        """
        Checks if number is valid
        Argument:
            column (int): the number column from user
        Return:

        """
        if 0 <= column < self.column:
            return self.data[0][column] == '.'
        if self.data[0][column] == '.':
            return

    def check_win(self, player):
        """
        Checks the board after every insertion to check winning scenerio.
        Horizontal, Vertical, \ win, / win

        Argument:
            player (char): the player piece
        Return:
            bool: True if one of the scenerio happens.
        """
    # Horizontal Win
        print(player)
        for row in range(0, self.row):
            for col in range(0, self.column-3):
                if self.data[row][col] == player and\
                 self.data[row][col+1] == player and\
                 self.data[row][col+2] == player and\
                 self.data[row][col+3] == player:
                    return True
        # Vertical Win
        for row in range(0, self.row-3):
            for col in range(0, self.column):
                if self.data[row][col] == player and\
                 self.data[row+1][col] == player and\
                 self.data[row+2][col] == player and\
                 self.data[row+3][col] == player:
                    return True
        # \ Win
        for row in range(0, self.row-3):
            for col in range(0, self.column-3):
                if self.data[row][col] == player and\
                 self.data[row+1][col+1] == player and\
                 self.data[row+2][col+2] == player and\
                 self.data[row+3][col+3] == player:
                    return True
        # / Win
        for row in range(0, self.row-3):
            for col in range(3, self.column):
                if self.data[row][col] == player and\
                 self.data[row+1][col-1] == player and\
                 self.data[row+2][col-2] == player and\
                 self.data[row+3][col-3] == player:
                    return True


def main():
    """
    main method
    prompts user and guides them to play.

    """
    game = Connect4()
    turn = PLAYER1
    print('Hello Players!. Player one your symbol is "R". Player two your symbol is "B"')
    print('Welcome to the Connect Four GAME! Connect 4 pieces to WIN')
    print('Press the correct column number you want to place your piece.(0-6)')

    while True:
        game.print_current()
        row = input('{}\'s turn: '.format('Player 1' if turn == PLAYER1 else 'Player 2'))
        game.add_move(int(row), turn)
        win = game.check_win(turn)
        if win is True:
            print('{}\'s is the WINNER!!! '.format('Player 1' if turn == PLAYER1 else 'Player 2'))
            break
        turn = PLAYER2 if turn == PLAYER1 else PLAYER1

main()
go = input('Go Another Round? Press "1" for yes "2" for No ')
if go == 2:
    print('BYE!')
else:
    main()
