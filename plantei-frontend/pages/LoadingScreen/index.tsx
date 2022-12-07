import Image from "next/image";
import Main from "../../components/Main";

import { ContainerLoading, PrincipalImage, StartImage, EndImage } from "../../styles/LoadingScreen";


export default function LoadingScreen() {
  return (
    <Main backgroundColor="#FFE490" padding="0">
      <ContainerLoading>
        <StartImage>
          <Image src="/icone_taioba1.svg" alt="Ícone plantei" width={149} height={250} layout="fixed" />
        </StartImage>
        <PrincipalImage>
          <Image src="/icone_plantei2.svg" alt="Ícone plantei" width={300} height={259} layout="fill" z-index="1" />
        </PrincipalImage>
        <EndImage>
          <Image src="/icone_taioba2.svg" alt="Ícone plantei" width={160} height={331} layout="fixed" />
        </EndImage>
      </ContainerLoading>
    </Main>
    );
  }
  

