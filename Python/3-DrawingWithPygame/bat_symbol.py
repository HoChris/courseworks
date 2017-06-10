"""
    Class to Generate the BatMobile
"""

import pygame

bat_img = pygame.image.load('batmobile.png')


class Symbol:
    """
    Creates the Batmobile and prints it to the screen
    """

    def __init__(self, x, y, screen):
        """
        Arg:
            x (int):  x axis postion
            y (int): y axis postion
            screen(pygame.display): the screen to display the picture

        """
        self.x = x
        self.y = y
        self.screen = screen

    def bat_symbol(self, x, y):
        """

        Prints the picture to the display
        Arg:
            x (int):  x axis postion
            y (int): y axis postion

        """
        self.screen.blit(bat_img, (x, y))

