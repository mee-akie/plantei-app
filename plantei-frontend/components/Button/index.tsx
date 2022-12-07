import React from "react";
import styled from "styled-components";

class ButtonProps {
  backgroundColor: string;
  width?: string;
  height?: string;
  children: React.ReactNode;
  padding?: string;
  color?: string;
  fontSize?: string;
  onClick?: () => void;
  type?: 'submit' | 'button';
  disabled?: boolean;
}

const ButtonStyled = styled.button<ButtonProps>`
  border: none;
  border-radius: 10px;
  width: ${props => props.width};
  height: ${props => props.height};
  padding: ${props => props.padding || '10px 20px'};
  background-color: ${props => props.backgroundColor};
  color: ${props => props.color};
  font-size: ${props => props.fontSize};
  cursor: pointer;

  &:hover {
    opacity: 0.8;
  }
`;

export default function Button({
  backgroundColor,
  width,
  height,
  children,
  padding,
  color,
  fontSize,
  onClick,
  type,
  disabled,
}: ButtonProps) {
  return (
    <ButtonStyled
      backgroundColor={backgroundColor}
      width={width}
      height={height}
      padding={padding}
      color={color}
      fontSize={fontSize}
      onClick={onClick}
      type={type}
      disabled={disabled}
    >
      {children}
    </ButtonStyled>
  );
}