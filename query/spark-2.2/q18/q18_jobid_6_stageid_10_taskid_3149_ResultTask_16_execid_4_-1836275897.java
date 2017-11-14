/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificSafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificSafeProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */   private Object[] values;
/* 010 */   private org.apache.spark.sql.types.StructType schema;
/* 011 */
/* 012 */   public SpecificSafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     mutableRow = (InternalRow) references[references.length - 1];
/* 015 */
/* 016 */     this.schema = (org.apache.spark.sql.types.StructType) references[0];
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_4(InternalRow i) {
/* 026 */
/* 027 */     boolean isNull18 = i.isNullAt(8);
/* 028 */     Decimal value18 = isNull18 ? null : (i.getDecimal(8, 16, 6));
/* 029 */     boolean isNull17 = true;
/* 030 */     java.math.BigDecimal value17 = null;
/* 031 */     if (!isNull18) {
/* 032 */
/* 033 */       isNull17 = false;
/* 034 */       if (!isNull17) {
/* 035 */
/* 036 */         Object funcResult8 = null;
/* 037 */         funcResult8 = value18.toJavaBigDecimal();
/* 038 */         value17 = (java.math.BigDecimal) funcResult8;
/* 039 */
/* 040 */       }
/* 041 */     }
/* 042 */     if (isNull17) {
/* 043 */       values[8] = null;
/* 044 */     } else {
/* 045 */       values[8] = value17;
/* 046 */     }
/* 047 */
/* 048 */     boolean isNull20 = i.isNullAt(9);
/* 049 */     Decimal value20 = isNull20 ? null : (i.getDecimal(9, 16, 6));
/* 050 */     boolean isNull19 = true;
/* 051 */     java.math.BigDecimal value19 = null;
/* 052 */     if (!isNull20) {
/* 053 */
/* 054 */       isNull19 = false;
/* 055 */       if (!isNull19) {
/* 056 */
/* 057 */         Object funcResult9 = null;
/* 058 */         funcResult9 = value20.toJavaBigDecimal();
/* 059 */         value19 = (java.math.BigDecimal) funcResult9;
/* 060 */
/* 061 */       }
/* 062 */     }
/* 063 */     if (isNull19) {
/* 064 */       values[9] = null;
/* 065 */     } else {
/* 066 */       values[9] = value19;
/* 067 */     }
/* 068 */
/* 069 */   }
/* 070 */
/* 071 */
/* 072 */   private void apply_1(InternalRow i) {
/* 073 */
/* 074 */     boolean isNull6 = i.isNullAt(2);
/* 075 */     UTF8String value6 = isNull6 ? null : (i.getUTF8String(2));
/* 076 */     boolean isNull5 = true;
/* 077 */     java.lang.String value5 = null;
/* 078 */     if (!isNull6) {
/* 079 */
/* 080 */       isNull5 = false;
/* 081 */       if (!isNull5) {
/* 082 */
/* 083 */         Object funcResult2 = null;
/* 084 */         funcResult2 = value6.toString();
/* 085 */         value5 = (java.lang.String) funcResult2;
/* 086 */
/* 087 */       }
/* 088 */     }
/* 089 */     if (isNull5) {
/* 090 */       values[2] = null;
/* 091 */     } else {
/* 092 */       values[2] = value5;
/* 093 */     }
/* 094 */
/* 095 */     boolean isNull8 = i.isNullAt(3);
/* 096 */     UTF8String value8 = isNull8 ? null : (i.getUTF8String(3));
/* 097 */     boolean isNull7 = true;
/* 098 */     java.lang.String value7 = null;
/* 099 */     if (!isNull8) {
/* 100 */
/* 101 */       isNull7 = false;
/* 102 */       if (!isNull7) {
/* 103 */
/* 104 */         Object funcResult3 = null;
/* 105 */         funcResult3 = value8.toString();
/* 106 */         value7 = (java.lang.String) funcResult3;
/* 107 */
/* 108 */       }
/* 109 */     }
/* 110 */     if (isNull7) {
/* 111 */       values[3] = null;
/* 112 */     } else {
/* 113 */       values[3] = value7;
/* 114 */     }
/* 115 */
/* 116 */   }
/* 117 */
/* 118 */
/* 119 */   private void apply_3(InternalRow i) {
/* 120 */
/* 121 */     boolean isNull14 = i.isNullAt(6);
/* 122 */     Decimal value14 = isNull14 ? null : (i.getDecimal(6, 16, 6));
/* 123 */     boolean isNull13 = true;
/* 124 */     java.math.BigDecimal value13 = null;
/* 125 */     if (!isNull14) {
/* 126 */
/* 127 */       isNull13 = false;
/* 128 */       if (!isNull13) {
/* 129 */
/* 130 */         Object funcResult6 = null;
/* 131 */         funcResult6 = value14.toJavaBigDecimal();
/* 132 */         value13 = (java.math.BigDecimal) funcResult6;
/* 133 */
/* 134 */       }
/* 135 */     }
/* 136 */     if (isNull13) {
/* 137 */       values[6] = null;
/* 138 */     } else {
/* 139 */       values[6] = value13;
/* 140 */     }
/* 141 */
/* 142 */     boolean isNull16 = i.isNullAt(7);
/* 143 */     Decimal value16 = isNull16 ? null : (i.getDecimal(7, 16, 6));
/* 144 */     boolean isNull15 = true;
/* 145 */     java.math.BigDecimal value15 = null;
/* 146 */     if (!isNull16) {
/* 147 */
/* 148 */       isNull15 = false;
/* 149 */       if (!isNull15) {
/* 150 */
/* 151 */         Object funcResult7 = null;
/* 152 */         funcResult7 = value16.toJavaBigDecimal();
/* 153 */         value15 = (java.math.BigDecimal) funcResult7;
/* 154 */
/* 155 */       }
/* 156 */     }
/* 157 */     if (isNull15) {
/* 158 */       values[7] = null;
/* 159 */     } else {
/* 160 */       values[7] = value15;
/* 161 */     }
/* 162 */
/* 163 */   }
/* 164 */
/* 165 */
/* 166 */   private void apply_0(InternalRow i) {
/* 167 */
/* 168 */     boolean isNull2 = i.isNullAt(0);
/* 169 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 170 */     boolean isNull1 = true;
/* 171 */     java.lang.String value1 = null;
/* 172 */     if (!isNull2) {
/* 173 */
/* 174 */       isNull1 = false;
/* 175 */       if (!isNull1) {
/* 176 */
/* 177 */         Object funcResult = null;
/* 178 */         funcResult = value2.toString();
/* 179 */         value1 = (java.lang.String) funcResult;
/* 180 */
/* 181 */       }
/* 182 */     }
/* 183 */     if (isNull1) {
/* 184 */       values[0] = null;
/* 185 */     } else {
/* 186 */       values[0] = value1;
/* 187 */     }
/* 188 */
/* 189 */     boolean isNull4 = i.isNullAt(1);
/* 190 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 191 */     boolean isNull3 = true;
/* 192 */     java.lang.String value3 = null;
/* 193 */     if (!isNull4) {
/* 194 */
/* 195 */       isNull3 = false;
/* 196 */       if (!isNull3) {
/* 197 */
/* 198 */         Object funcResult1 = null;
/* 199 */         funcResult1 = value4.toString();
/* 200 */         value3 = (java.lang.String) funcResult1;
/* 201 */
/* 202 */       }
/* 203 */     }
/* 204 */     if (isNull3) {
/* 205 */       values[1] = null;
/* 206 */     } else {
/* 207 */       values[1] = value3;
/* 208 */     }
/* 209 */
/* 210 */   }
/* 211 */
/* 212 */
/* 213 */   private void apply_2(InternalRow i) {
/* 214 */
/* 215 */     boolean isNull10 = i.isNullAt(4);
/* 216 */     Decimal value10 = isNull10 ? null : (i.getDecimal(4, 16, 6));
/* 217 */     boolean isNull9 = true;
/* 218 */     java.math.BigDecimal value9 = null;
/* 219 */     if (!isNull10) {
/* 220 */
/* 221 */       isNull9 = false;
/* 222 */       if (!isNull9) {
/* 223 */
/* 224 */         Object funcResult4 = null;
/* 225 */         funcResult4 = value10.toJavaBigDecimal();
/* 226 */         value9 = (java.math.BigDecimal) funcResult4;
/* 227 */
/* 228 */       }
/* 229 */     }
/* 230 */     if (isNull9) {
/* 231 */       values[4] = null;
/* 232 */     } else {
/* 233 */       values[4] = value9;
/* 234 */     }
/* 235 */
/* 236 */     boolean isNull12 = i.isNullAt(5);
/* 237 */     Decimal value12 = isNull12 ? null : (i.getDecimal(5, 16, 6));
/* 238 */     boolean isNull11 = true;
/* 239 */     java.math.BigDecimal value11 = null;
/* 240 */     if (!isNull12) {
/* 241 */
/* 242 */       isNull11 = false;
/* 243 */       if (!isNull11) {
/* 244 */
/* 245 */         Object funcResult5 = null;
/* 246 */         funcResult5 = value12.toJavaBigDecimal();
/* 247 */         value11 = (java.math.BigDecimal) funcResult5;
/* 248 */
/* 249 */       }
/* 250 */     }
/* 251 */     if (isNull11) {
/* 252 */       values[5] = null;
/* 253 */     } else {
/* 254 */       values[5] = value11;
/* 255 */     }
/* 256 */
/* 257 */   }
/* 258 */
/* 259 */
/* 260 */   private void apply_5(InternalRow i) {
/* 261 */
/* 262 */     boolean isNull22 = i.isNullAt(10);
/* 263 */     Decimal value22 = isNull22 ? null : (i.getDecimal(10, 16, 6));
/* 264 */     boolean isNull21 = true;
/* 265 */     java.math.BigDecimal value21 = null;
/* 266 */     if (!isNull22) {
/* 267 */
/* 268 */       isNull21 = false;
/* 269 */       if (!isNull21) {
/* 270 */
/* 271 */         Object funcResult10 = null;
/* 272 */         funcResult10 = value22.toJavaBigDecimal();
/* 273 */         value21 = (java.math.BigDecimal) funcResult10;
/* 274 */
/* 275 */       }
/* 276 */     }
/* 277 */     if (isNull21) {
/* 278 */       values[10] = null;
/* 279 */     } else {
/* 280 */       values[10] = value21;
/* 281 */     }
/* 282 */
/* 283 */   }
/* 284 */
/* 285 */
/* 286 */   public java.lang.Object apply(java.lang.Object _i) {
/* 287 */     InternalRow i = (InternalRow) _i;
/* 288 */
/* 289 */     values = new Object[11];
/* 290 */     apply_0(i);
/* 291 */     apply_1(i);
/* 292 */     apply_2(i);
/* 293 */     apply_3(i);
/* 294 */     apply_4(i);
/* 295 */     apply_5(i);
/* 296 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 297 */     if (false) {
/* 298 */       mutableRow.setNullAt(0);
/* 299 */     } else {
/* 300 */
/* 301 */       mutableRow.update(0, value);
/* 302 */     }
/* 303 */
/* 304 */     return mutableRow;
/* 305 */   }
/* 306 */ }
