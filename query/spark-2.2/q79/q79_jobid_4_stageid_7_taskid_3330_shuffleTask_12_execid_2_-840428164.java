/* 001 */ public SpecificOrdering generate(Object[] references) {
/* 002 */   return new SpecificOrdering(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificOrdering extends org.apache.spark.sql.catalyst.expressions.codegen.BaseOrdering {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */
/* 009 */
/* 010 */   public SpecificOrdering(Object[] references) {
/* 011 */     this.references = references;
/* 012 */
/* 013 */   }
/* 014 */
/* 015 */
/* 016 */   private int compare_2(InternalRow a, InternalRow b) {
/* 017 */
/* 018 */     InternalRow i = null;  // Holds current row being evaluated.
/* 019 */
/* 020 */     i = a;
/* 021 */     boolean isNullA3;
/* 022 */     double primitiveA3;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull6 = i.isNullAt(5);
/* 026 */       double value6 = isNull6 ? -1.0 : (i.getDouble(5));
/* 027 */       isNullA3 = isNull6;
/* 028 */       primitiveA3 = value6;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB3;
/* 032 */     double primitiveB3;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull6 = i.isNullAt(5);
/* 036 */       double value6 = isNull6 ? -1.0 : (i.getDouble(5));
/* 037 */       isNullB3 = isNull6;
/* 038 */       primitiveB3 = value6;
/* 039 */     }
/* 040 */     if (isNullA3 && isNullB3) {
/* 041 */       // Nothing
/* 042 */     } else if (isNullA3) {
/* 043 */       return -1;
/* 044 */     } else if (isNullB3) {
/* 045 */       return 1;
/* 046 */     } else {
/* 047 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA3, primitiveB3);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */     return 0;
/* 054 */
/* 055 */   }
/* 056 */
/* 057 */
/* 058 */   private int compare_1(InternalRow a, InternalRow b) {
/* 059 */
/* 060 */     InternalRow i = null;  // Holds current row being evaluated.
/* 061 */
/* 062 */     i = a;
/* 063 */     boolean isNullA2;
/* 064 */     UTF8String primitiveA2;
/* 065 */     {
/* 066 */
/* 067 */       boolean isNull2 = true;
/* 068 */       UTF8String value2 = null;
/* 069 */
/* 070 */       boolean isNull3 = i.isNullAt(6);
/* 071 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(6));
/* 072 */       if (!isNull3) {
/* 073 */
/* 074 */
/* 075 */
/* 076 */         isNull2 = false; // resultCode could change nullability.
/* 077 */         value2 = value3.substringSQL(1, 30);
/* 078 */
/* 079 */       }
/* 080 */       isNullA2 = isNull2;
/* 081 */       primitiveA2 = value2;
/* 082 */     }
/* 083 */     i = b;
/* 084 */     boolean isNullB2;
/* 085 */     UTF8String primitiveB2;
/* 086 */     {
/* 087 */
/* 088 */       boolean isNull2 = true;
/* 089 */       UTF8String value2 = null;
/* 090 */
/* 091 */       boolean isNull3 = i.isNullAt(6);
/* 092 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(6));
/* 093 */       if (!isNull3) {
/* 094 */
/* 095 */
/* 096 */
/* 097 */         isNull2 = false; // resultCode could change nullability.
/* 098 */         value2 = value3.substringSQL(1, 30);
/* 099 */
/* 100 */       }
/* 101 */       isNullB2 = isNull2;
/* 102 */       primitiveB2 = value2;
/* 103 */     }
/* 104 */     if (isNullA2 && isNullB2) {
/* 105 */       // Nothing
/* 106 */     } else if (isNullA2) {
/* 107 */       return -1;
/* 108 */     } else if (isNullB2) {
/* 109 */       return 1;
/* 110 */     } else {
/* 111 */       int comp = primitiveA2.compare(primitiveB2);
/* 112 */       if (comp != 0) {
/* 113 */         return comp;
/* 114 */       }
/* 115 */     }
/* 116 */
/* 117 */     return 0;
/* 118 */
/* 119 */   }
/* 120 */
/* 121 */
/* 122 */   private int compare_0(InternalRow a, InternalRow b) {
/* 123 */
/* 124 */     InternalRow i = null;  // Holds current row being evaluated.
/* 125 */
/* 126 */     i = a;
/* 127 */     boolean isNullA;
/* 128 */     UTF8String primitiveA;
/* 129 */     {
/* 130 */
/* 131 */       boolean isNull = i.isNullAt(0);
/* 132 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 133 */       isNullA = isNull;
/* 134 */       primitiveA = value;
/* 135 */     }
/* 136 */     i = b;
/* 137 */     boolean isNullB;
/* 138 */     UTF8String primitiveB;
/* 139 */     {
/* 140 */
/* 141 */       boolean isNull = i.isNullAt(0);
/* 142 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 143 */       isNullB = isNull;
/* 144 */       primitiveB = value;
/* 145 */     }
/* 146 */     if (isNullA && isNullB) {
/* 147 */       // Nothing
/* 148 */     } else if (isNullA) {
/* 149 */       return -1;
/* 150 */     } else if (isNullB) {
/* 151 */       return 1;
/* 152 */     } else {
/* 153 */       int comp = primitiveA.compare(primitiveB);
/* 154 */       if (comp != 0) {
/* 155 */         return comp;
/* 156 */       }
/* 157 */     }
/* 158 */
/* 159 */     i = a;
/* 160 */     boolean isNullA1;
/* 161 */     UTF8String primitiveA1;
/* 162 */     {
/* 163 */
/* 164 */       boolean isNull1 = i.isNullAt(1);
/* 165 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 166 */       isNullA1 = isNull1;
/* 167 */       primitiveA1 = value1;
/* 168 */     }
/* 169 */     i = b;
/* 170 */     boolean isNullB1;
/* 171 */     UTF8String primitiveB1;
/* 172 */     {
/* 173 */
/* 174 */       boolean isNull1 = i.isNullAt(1);
/* 175 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 176 */       isNullB1 = isNull1;
/* 177 */       primitiveB1 = value1;
/* 178 */     }
/* 179 */     if (isNullA1 && isNullB1) {
/* 180 */       // Nothing
/* 181 */     } else if (isNullA1) {
/* 182 */       return -1;
/* 183 */     } else if (isNullB1) {
/* 184 */       return 1;
/* 185 */     } else {
/* 186 */       int comp = primitiveA1.compare(primitiveB1);
/* 187 */       if (comp != 0) {
/* 188 */         return comp;
/* 189 */       }
/* 190 */     }
/* 191 */
/* 192 */     return 0;
/* 193 */
/* 194 */   }
/* 195 */
/* 196 */
/* 197 */   public int compare(InternalRow a, InternalRow b) {
/* 198 */
/* 199 */     InternalRow i = null;
/* 200 */
/* 201 */     int comp = compare_0(a, b);
/* 202 */     if (comp != 0) {
/* 203 */       return comp;
/* 204 */     }
/* 205 */
/* 206 */     int comp1 = compare_1(a, b);
/* 207 */     if (comp1 != 0) {
/* 208 */       return comp1;
/* 209 */     }
/* 210 */
/* 211 */     int comp2 = compare_2(a, b);
/* 212 */     if (comp2 != 0) {
/* 213 */       return comp2;
/* 214 */     }
/* 215 */
/* 216 */
/* 217 */     return 0;
/* 218 */   }
/* 219 */ }
