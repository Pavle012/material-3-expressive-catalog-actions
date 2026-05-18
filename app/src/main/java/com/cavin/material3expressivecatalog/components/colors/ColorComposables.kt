/*
 * Designed and developed by MetichaHQ
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cavin.material3expressivecatalog.components.colors

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cavin.material3expressivecatalog.ui.composables.ListTile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorListingScreen(
    onNavigateToRoles: () -> Unit,
    onNavigateToExamples: () -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Color System") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(16.dp))
            Icon(
                imageVector = Icons.Default.Palette,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Material 3 Colors",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Explore the Material 3 color system, including dynamic color roles and how they are applied to components.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(Modifier.height(24.dp))

            Text(text = "Sections", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))

            ListTile(
                onClick = onNavigateToRoles,
                title = "Color Roles",
                description = "Comprehensive list of all Material 3 color roles and descriptions."
            )

            ListTile(
                onClick = onNavigateToExamples,
                title = "Color Usage Examples",
                description = "See how different color roles are applied to buttons, cards, and more."
            )
        }
    }
}

data class ColorRole(
    val name: String,
    val color: Color,
    val onColor: Color,
    val description: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorRolesScreen(onBack: () -> Unit) {
    val colorScheme = MaterialTheme.colorScheme
    val coreColors = listOf(
        ColorRole("Primary", colorScheme.primary, colorScheme.onPrimary, "Main brand color for FABs and primary buttons."),
        ColorRole("Primary Container", colorScheme.primaryContainer, colorScheme.onPrimaryContainer, "Less prominent background for primary elements."),
        ColorRole("Secondary", colorScheme.secondary, colorScheme.onSecondary, "Accents for secondary actions and UI elements."),
        ColorRole("Secondary Container", colorScheme.secondaryContainer, colorScheme.onSecondaryContainer, "Background for secondary accents."),
        ColorRole("Tertiary", colorScheme.tertiary, colorScheme.onTertiary, "Contrasting accents to balance the UI."),
        ColorRole("Tertiary Container", colorScheme.tertiaryContainer, colorScheme.onTertiaryContainer, "Background for tertiary accents."),
        ColorRole("Error", colorScheme.error, colorScheme.onError, "Indicates errors and destructive actions."),
        ColorRole("Error Container", colorScheme.errorContainer, colorScheme.onErrorContainer, "Background for error states."),
    )

    val surfaceColors = listOf(
        ColorRole("Background", colorScheme.background, colorScheme.onBackground, "Default background for the entire screen."),
        ColorRole("Surface", colorScheme.surface, colorScheme.onSurface, "Default background for components like cards and dialogs."),
        ColorRole("Surface Variant", colorScheme.surfaceVariant, colorScheme.onSurfaceVariant, "Alternative surface color with different contrast."),
        ColorRole("Surface Dim", colorScheme.surfaceDim, colorScheme.onSurface, "A darker surface color for providing depth."),
        ColorRole("Surface Bright", colorScheme.surfaceBright, colorScheme.onSurface, "A brighter surface color for high emphasis."),
        ColorRole("Surface Container Lowest", colorScheme.surfaceContainerLowest, colorScheme.onSurface, "Lowest emphasis container color."),
        ColorRole("Surface Container Low", colorScheme.surfaceContainerLow, colorScheme.onSurface, "Low emphasis container color."),
        ColorRole("Surface Container", colorScheme.surfaceContainer, colorSurface(colorScheme), "Default emphasis container color."),
        ColorRole("Surface Container High", colorScheme.surfaceContainerHigh, colorSurface(colorScheme), "High emphasis container color."),
        ColorRole("Surface Container Highest", colorScheme.surfaceContainerHighest, colorSurface(colorScheme), "Highest emphasis container color."),
        ColorRole("Outline", colorScheme.outline, colorScheme.onSurface, "Used for component borders and dividers."),
        ColorRole("Outline Variant", colorScheme.outlineVariant, colorScheme.onSurfaceVariant, "Lower-contrast outline for subtle boundaries."),
        ColorRole("Inverse Surface", colorScheme.inverseSurface, colorScheme.inverseOnSurface, "A high-contrast background for snackbars and tooltips."),
        ColorRole("Inverse On Surface", colorScheme.inverseOnSurface, colorScheme.inverseSurface, "High-contrast text color for inverse surfaces."),
        ColorRole("Inverse Primary", colorScheme.inversePrimary, colorScheme.primary, "Primary color for use on inverse surfaces (e.g. snackbar action)."),
    )

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Color Roles") },
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        )
    }) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    "Brand & Accent Roles",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
                )
                Text(
                    "Primary, Secondary, and Tertiary color roles drive the brand expression of your app.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
            }

            items(coreColors) { role ->
                ColorItemDetail(role)
            }

            item {
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                Text(
                    "Surface & Neutral Roles",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )
                Text(
                    "Neutral roles are used for backgrounds and surfaces, as well as high-emphasis and low-emphasis text.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
            }

            items(surfaceColors) { role ->
                ColorItemDetail(role)
            }

            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

// Helper to get correct on-color for surfaces if needed, usually onSurface
@Composable
fun colorSurface(colorScheme: androidx.compose.material3.ColorScheme): Color = colorScheme.onSurface

@Composable
fun ColorItemDetail(role: ColorRole) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = role.color,
            contentColor = role.onColor
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = role.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = role.color.toHexString(),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier
                        .background(role.onColor.copy(alpha = 0.1f), CircleShape)
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = role.description,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(role.onColor, CircleShape)
                        .border(1.dp, role.color.copy(alpha = 0.2f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Aa",
                        style = MaterialTheme.typography.labelSmall,
                        color = role.color,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "On ${role.name}",
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorExamplesScreen(onBack: () -> Unit) {
    val colorScheme = MaterialTheme.colorScheme
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Color Usage Examples") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                Text(
                    "Buttons",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text("Filled (Primary)")
                    }
                    ElevatedButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text("Elevated")
                    }
                    FilledTonalButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text("Tonal (Secondary Container)")
                    }
                    OutlinedButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text("Outlined")
                    }
                    TextButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text("Text Button")
                    }
                }
            }

            item {
                Text(
                    "Cards",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceVariant)
                    ) {
                        Box(Modifier.padding(16.dp)) { Text("Filled Card (Surface Variant)") }
                    }
                    ElevatedCard(modifier = Modifier.fillMaxWidth()) {
                        Box(Modifier.padding(16.dp)) { Text("Elevated Card") }
                    }
                    OutlinedCard(modifier = Modifier.fillMaxWidth()) {
                        Box(Modifier.padding(16.dp)) { Text("Outlined Card") }
                    }
                }
            }

            item {
                Text(
                    "Error States",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = colorScheme.errorContainer,
                        contentColor = colorScheme.onErrorContainer
                    )
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Something went wrong", style = MaterialTheme.typography.titleMedium)
                        Text("This container uses errorContainer and onErrorContainer colors.", style = MaterialTheme.typography.bodySmall)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorScheme.error,
                                contentColor = colorScheme.onError
                            )
                        ) {
                            Text("Retry Action")
                        }
                    }
                }
            }

            item {
                Text(
                    "Inverse Colors (Snackbar Style)",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = colorScheme.inverseSurface,
                        contentColor = colorScheme.inverseOnSurface
                    ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("This is an inverse surface", style = MaterialTheme.typography.bodyMedium)
                        TextButton(
                            onClick = {},
                            colors = ButtonDefaults.textButtonColors(contentColor = colorScheme.inversePrimary)
                        ) {
                            Text("ACTION")
                        }
                    }
                }
                Text(
                    "Inverse roles provide high contrast, typically used for transient UI like Snackbars.",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            item {
                Text(
                    "Custom Shapes & Colors",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                ButtonExampleSection()
            }

            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

fun Color.toHexString(): String {
    return "#%08X".format(toArgb())
}

@Composable
fun ButtonExampleSection() {
    val colorScheme = MaterialTheme.colorScheme
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        ButtonExampleRow(
            label = "Primary Role (Rounded)",
            color = colorScheme.primary,
            onColor = colorScheme.onPrimary,
            shape = RoundedCornerShape(16.dp),
            isIcon = false,
            text = "Primary Action"
        )

        ButtonExampleRow(
            label = "Secondary Role (Default)",
            color = colorScheme.secondary,
            onColor = colorScheme.onSecondary,
            shape = ButtonDefaults.shape,
            isIcon = false,
            text = "Secondary Action"
        )

        ButtonExampleRow(
            label = "Tertiary Role (Circle)",
            color = colorScheme.tertiary,
            onColor = colorScheme.onTertiary,
            shape = CircleShape,
            isIcon = true,
            text = ""
        )
    }
}

@Composable
fun ButtonExampleRow(
    label: String,
    color: Color,
    onColor: Color,
    shape: Shape,
    isIcon: Boolean,
    text: String
) {
    val colorScheme = MaterialTheme.colorScheme
    Column {
        Text(text = label, style = MaterialTheme.typography.labelMedium, color = colorScheme.outline)
        Spacer(modifier = Modifier.height(4.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = color, contentColor = onColor),
            shape = shape,
            modifier = if (isIcon) Modifier.size(48.dp) else Modifier.fillMaxWidth()
        ) {
            if (isIcon) {
                Icon(Icons.Default.Favorite, contentDescription = null)
            } else {
                Text(text = text)
            }
        }
    }
}
