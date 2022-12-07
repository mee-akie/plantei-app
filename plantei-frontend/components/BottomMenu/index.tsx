import React from "react";
import styled from "styled-components";
import Button from "../Button/index";
import Image from "next/image";
import { useRouter } from "next/router";

class BottomMenuProps {
  backgroundColor: string;
  width?: string;
  height?: string;
  children?: React.ReactNode;
  padding?: string;
  color?: string;
}

const BottomMenuStyled = styled.footer<BottomMenuProps>`
  display: flex;
  justify-content: space-around;
  border: none;
  border-radius: 10px;
  width: ${props => props.width || '100%'};
  height: ${props => props.height};
  background-color: ${props => props.backgroundColor};
  color: ${props => props.color};
  cursor: pointer;

  position: fixed;
  bottom: 0;
  left: 0;

  &:hover {
    opacity: 0.8;
  }
`;

export default function BottomMenu({
  backgroundColor,
  width,
  height,
  children,
  padding,
  color,
}: BottomMenuProps) {
  const router = useRouter()
  return (
    <BottomMenuStyled
      backgroundColor={backgroundColor}
      width={width}
      height={height}
      padding={padding}
      color={color}
    >
      <Button
        backgroundColor="#FFFFFF"
        width="min-content"
        color="#ff2a00"
        type="button"
        onClick={() => router.push('/Login')}
      >
        <Image src="/navbar_home.svg" alt="Ícone plantei" width={60} height={60} layout="fixed" />
      </Button>
      <Button
        backgroundColor="#FFFFFF"
        width="min-content"
        color="#7B7878"
        type="button"
        onClick={() => router.push('/NovaPlanta')}
      >
        <Image src="/navbar_planta.svg" alt="Ícone plantei" width={60} height={60} layout="fixed" />
      </Button>
      <Button
        backgroundColor="#FFFFFF"
        width="min-content"
        color="#7B7878"
        type="button"
        onClick={() => router.push('/Profile')}
      >
        <Image color="#34AE62" src="/navbar_perfil.svg" alt="Ícone plantei" width={60} height={60} layout="fixed" />
      </Button>
      <Button
        backgroundColor="#FFFFFF"
        width="min-content"
        color="#7B7878"
        disabled
      >
        <Image src="/navbar_feed.svg" alt="Ícone plantei" width={60} height={60} layout="fixed" />
      </Button>
      {children}
    </BottomMenuStyled>
  );
}