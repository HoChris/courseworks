"""
    Class that generates the buildings with windows
    on the buildings

    Color for WHITE is set
"""

import pygame

WHITE = (255, 255, 255)


class Building:

    def __init__(self, x, y, size, colors):
        """

        Arg:
            x (int):  x axis postion
            y (int): y axis postion
            size (int): the size of the building
            colors(pygame.Color):

        """
        self.x = x
        self.y = y
        self.size = size
        self.colors = colors

    def draw(self, screen):
        """
            Draws the building using the parameters. The buildings also have windows

            Args:
                screen (pygame.display): Displays the building onto the screen
        """
        pygame.draw.rect(screen, self.colors, [self.x, self.y, self.size/3, self.size])
        self.__build_windows(screen)

    def __build_windows(self, screen):
        """
            Draws the windows onto the buildings. Different window sizes and postions
            are drawn onto the buildings to give a less uniform look to each building

            Args:
                screen (pygame.display): Displays the building onto the screen

        """
        x = self.x
        y = self.y

        for i in range(0, 10):
            pygame.draw.line(screen, WHITE, (x + 20, y + 5), (x + 75, y + 5), 2)
            pygame.draw.line(screen, WHITE, (x + 15, y + 10), (x + 25, y + 10), 1)
            pygame.draw.line(screen, WHITE, (x + 35, y + 12), (x + 55, y + 12), 4)
            pygame.draw.line(screen, WHITE, (x + 35, y + 20), (x + 45, y + 20), 7)
            y += 20
            x += 5
            if y % 5 == 0:
                x += 2
                y += -1
            elif x % 2 == 0:
                x += -10
                y += 5
