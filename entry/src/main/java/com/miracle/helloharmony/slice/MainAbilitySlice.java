package com.miracle.helloharmony.slice;

import com.miracle.helloharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main); // 加载XML布局
        Button button = (Button) findComponentById(ResourceTable.Id_button);

        if (button != null) {
            // 为按钮设置点击回调
            button.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    Intent secondIntent = new Intent();
                    // 指定待启动FA的bundleName和abilityName
                    Operation operation = new Intent.OperationBuilder()
                            .withDeviceId("")
                            .withBundleName("com.miracle.helloharmony")
                            .withAbilityName("com.miracle.helloharmony.SecondAbility")
                            .build();
                    secondIntent.setOperation(operation);
                    // 通过AbilitySlice的startAbility接口实现启动另一个页面
                    startAbility(secondIntent);
                }
            });
        }
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
