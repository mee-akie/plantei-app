import styled from "styled-components";
import { ChangeEvent, useState } from "react";


class ToggleProps {
  children: React.ReactNode;
}

const ContentToggle = styled.span`
  display: flex;
  align-items: center;
  width: 100%;
`;

const ToggleDescription = styled.span`
  padding: 0px 10px;
  color: #9AC979;
  font-size: 13px;
  font-weight: 600;
`;

const StyledToggle = styled.label<{ checked: boolean }>`
  cursor: pointer;
  text-indent: -9999px;
  min-width: 40px;
  height: 25px;
  background: ${({ checked }) => (checked ? '#9AC979' : '#F4F4F4')};
  display: block;
  border-radius: 100px;
  position: relative;
  &:after {
    content: "";
    position: absolute;
    left: ${({ checked }) => (checked ? "17px" : "calc(20% - 5px)")};
    top: 2.5px;
    width: 20px;
    height: 20px;
    background: #fff;
    border-radius: 90px;
    transition: 0.3s;
  }
`;

export default function ToggleSwitch({children}: ToggleProps) {
  const [switchState, setSwitchState] = useState(true);
  function handleOnChange(e: ChangeEvent<HTMLInputElement>) {
    console.log("---", e.target.checked);
    setSwitchState(!switchState);
  }
  return (
    <ContentToggle>
      <StyledToggle htmlFor="checkbox" checked={switchState}>
        <input
          id="checkbox"
          type="checkbox"
          checked={switchState}
          onChange={handleOnChange}
        />
      </StyledToggle>
      <ToggleDescription>{children}</ToggleDescription>
    </ContentToggle>
  );
}