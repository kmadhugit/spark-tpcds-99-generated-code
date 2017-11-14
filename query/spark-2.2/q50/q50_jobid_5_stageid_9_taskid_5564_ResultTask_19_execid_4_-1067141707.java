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
/* 027 */     boolean isNull19 = i.isNullAt(9);
/* 028 */     UTF8String value19 = isNull19 ? null : (i.getUTF8String(9));
/* 029 */     boolean isNull18 = true;
/* 030 */     java.lang.String value18 = null;
/* 031 */     if (!isNull19) {
/* 032 */
/* 033 */       isNull18 = false;
/* 034 */       if (!isNull18) {
/* 035 */
/* 036 */         Object funcResult8 = null;
/* 037 */         funcResult8 = value19.toString();
/* 038 */         value18 = (java.lang.String) funcResult8;
/* 039 */
/* 040 */       }
/* 041 */     }
/* 042 */     if (isNull18) {
/* 043 */       values[9] = null;
/* 044 */     } else {
/* 045 */       values[9] = value18;
/* 046 */     }
/* 047 */
/* 048 */     boolean isNull20 = i.isNullAt(10);
/* 049 */     long value20 = isNull20 ? -1L : (i.getLong(10));
/* 050 */     if (isNull20) {
/* 051 */       values[10] = null;
/* 052 */     } else {
/* 053 */       values[10] = value20;
/* 054 */     }
/* 055 */
/* 056 */     boolean isNull21 = i.isNullAt(11);
/* 057 */     long value21 = isNull21 ? -1L : (i.getLong(11));
/* 058 */     if (isNull21) {
/* 059 */       values[11] = null;
/* 060 */     } else {
/* 061 */       values[11] = value21;
/* 062 */     }
/* 063 */
/* 064 */     boolean isNull22 = i.isNullAt(12);
/* 065 */     long value22 = isNull22 ? -1L : (i.getLong(12));
/* 066 */     if (isNull22) {
/* 067 */       values[12] = null;
/* 068 */     } else {
/* 069 */       values[12] = value22;
/* 070 */     }
/* 071 */
/* 072 */   }
/* 073 */
/* 074 */
/* 075 */   private void apply_1(InternalRow i) {
/* 076 */
/* 077 */     boolean isNull7 = i.isNullAt(3);
/* 078 */     UTF8String value7 = isNull7 ? null : (i.getUTF8String(3));
/* 079 */     boolean isNull6 = true;
/* 080 */     java.lang.String value6 = null;
/* 081 */     if (!isNull7) {
/* 082 */
/* 083 */       isNull6 = false;
/* 084 */       if (!isNull6) {
/* 085 */
/* 086 */         Object funcResult2 = null;
/* 087 */         funcResult2 = value7.toString();
/* 088 */         value6 = (java.lang.String) funcResult2;
/* 089 */
/* 090 */       }
/* 091 */     }
/* 092 */     if (isNull6) {
/* 093 */       values[3] = null;
/* 094 */     } else {
/* 095 */       values[3] = value6;
/* 096 */     }
/* 097 */
/* 098 */     boolean isNull9 = i.isNullAt(4);
/* 099 */     UTF8String value9 = isNull9 ? null : (i.getUTF8String(4));
/* 100 */     boolean isNull8 = true;
/* 101 */     java.lang.String value8 = null;
/* 102 */     if (!isNull9) {
/* 103 */
/* 104 */       isNull8 = false;
/* 105 */       if (!isNull8) {
/* 106 */
/* 107 */         Object funcResult3 = null;
/* 108 */         funcResult3 = value9.toString();
/* 109 */         value8 = (java.lang.String) funcResult3;
/* 110 */
/* 111 */       }
/* 112 */     }
/* 113 */     if (isNull8) {
/* 114 */       values[4] = null;
/* 115 */     } else {
/* 116 */       values[4] = value8;
/* 117 */     }
/* 118 */
/* 119 */   }
/* 120 */
/* 121 */
/* 122 */   private void apply_3(InternalRow i) {
/* 123 */
/* 124 */     boolean isNull15 = i.isNullAt(7);
/* 125 */     UTF8String value15 = isNull15 ? null : (i.getUTF8String(7));
/* 126 */     boolean isNull14 = true;
/* 127 */     java.lang.String value14 = null;
/* 128 */     if (!isNull15) {
/* 129 */
/* 130 */       isNull14 = false;
/* 131 */       if (!isNull14) {
/* 132 */
/* 133 */         Object funcResult6 = null;
/* 134 */         funcResult6 = value15.toString();
/* 135 */         value14 = (java.lang.String) funcResult6;
/* 136 */
/* 137 */       }
/* 138 */     }
/* 139 */     if (isNull14) {
/* 140 */       values[7] = null;
/* 141 */     } else {
/* 142 */       values[7] = value14;
/* 143 */     }
/* 144 */
/* 145 */     boolean isNull17 = i.isNullAt(8);
/* 146 */     UTF8String value17 = isNull17 ? null : (i.getUTF8String(8));
/* 147 */     boolean isNull16 = true;
/* 148 */     java.lang.String value16 = null;
/* 149 */     if (!isNull17) {
/* 150 */
/* 151 */       isNull16 = false;
/* 152 */       if (!isNull16) {
/* 153 */
/* 154 */         Object funcResult7 = null;
/* 155 */         funcResult7 = value17.toString();
/* 156 */         value16 = (java.lang.String) funcResult7;
/* 157 */
/* 158 */       }
/* 159 */     }
/* 160 */     if (isNull16) {
/* 161 */       values[8] = null;
/* 162 */     } else {
/* 163 */       values[8] = value16;
/* 164 */     }
/* 165 */
/* 166 */   }
/* 167 */
/* 168 */
/* 169 */   private void apply_0(InternalRow i) {
/* 170 */
/* 171 */     boolean isNull2 = i.isNullAt(0);
/* 172 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 173 */     boolean isNull1 = true;
/* 174 */     java.lang.String value1 = null;
/* 175 */     if (!isNull2) {
/* 176 */
/* 177 */       isNull1 = false;
/* 178 */       if (!isNull1) {
/* 179 */
/* 180 */         Object funcResult = null;
/* 181 */         funcResult = value2.toString();
/* 182 */         value1 = (java.lang.String) funcResult;
/* 183 */
/* 184 */       }
/* 185 */     }
/* 186 */     if (isNull1) {
/* 187 */       values[0] = null;
/* 188 */     } else {
/* 189 */       values[0] = value1;
/* 190 */     }
/* 191 */
/* 192 */     boolean isNull3 = i.isNullAt(1);
/* 193 */     int value3 = isNull3 ? -1 : (i.getInt(1));
/* 194 */     if (isNull3) {
/* 195 */       values[1] = null;
/* 196 */     } else {
/* 197 */       values[1] = value3;
/* 198 */     }
/* 199 */
/* 200 */     boolean isNull5 = i.isNullAt(2);
/* 201 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(2));
/* 202 */     boolean isNull4 = true;
/* 203 */     java.lang.String value4 = null;
/* 204 */     if (!isNull5) {
/* 205 */
/* 206 */       isNull4 = false;
/* 207 */       if (!isNull4) {
/* 208 */
/* 209 */         Object funcResult1 = null;
/* 210 */         funcResult1 = value5.toString();
/* 211 */         value4 = (java.lang.String) funcResult1;
/* 212 */
/* 213 */       }
/* 214 */     }
/* 215 */     if (isNull4) {
/* 216 */       values[2] = null;
/* 217 */     } else {
/* 218 */       values[2] = value4;
/* 219 */     }
/* 220 */
/* 221 */   }
/* 222 */
/* 223 */
/* 224 */   private void apply_2(InternalRow i) {
/* 225 */
/* 226 */     boolean isNull11 = i.isNullAt(5);
/* 227 */     UTF8String value11 = isNull11 ? null : (i.getUTF8String(5));
/* 228 */     boolean isNull10 = true;
/* 229 */     java.lang.String value10 = null;
/* 230 */     if (!isNull11) {
/* 231 */
/* 232 */       isNull10 = false;
/* 233 */       if (!isNull10) {
/* 234 */
/* 235 */         Object funcResult4 = null;
/* 236 */         funcResult4 = value11.toString();
/* 237 */         value10 = (java.lang.String) funcResult4;
/* 238 */
/* 239 */       }
/* 240 */     }
/* 241 */     if (isNull10) {
/* 242 */       values[5] = null;
/* 243 */     } else {
/* 244 */       values[5] = value10;
/* 245 */     }
/* 246 */
/* 247 */     boolean isNull13 = i.isNullAt(6);
/* 248 */     UTF8String value13 = isNull13 ? null : (i.getUTF8String(6));
/* 249 */     boolean isNull12 = true;
/* 250 */     java.lang.String value12 = null;
/* 251 */     if (!isNull13) {
/* 252 */
/* 253 */       isNull12 = false;
/* 254 */       if (!isNull12) {
/* 255 */
/* 256 */         Object funcResult5 = null;
/* 257 */         funcResult5 = value13.toString();
/* 258 */         value12 = (java.lang.String) funcResult5;
/* 259 */
/* 260 */       }
/* 261 */     }
/* 262 */     if (isNull12) {
/* 263 */       values[6] = null;
/* 264 */     } else {
/* 265 */       values[6] = value12;
/* 266 */     }
/* 267 */
/* 268 */   }
/* 269 */
/* 270 */
/* 271 */   private void apply_5(InternalRow i) {
/* 272 */
/* 273 */     boolean isNull23 = i.isNullAt(13);
/* 274 */     long value23 = isNull23 ? -1L : (i.getLong(13));
/* 275 */     if (isNull23) {
/* 276 */       values[13] = null;
/* 277 */     } else {
/* 278 */       values[13] = value23;
/* 279 */     }
/* 280 */
/* 281 */     boolean isNull24 = i.isNullAt(14);
/* 282 */     long value24 = isNull24 ? -1L : (i.getLong(14));
/* 283 */     if (isNull24) {
/* 284 */       values[14] = null;
/* 285 */     } else {
/* 286 */       values[14] = value24;
/* 287 */     }
/* 288 */
/* 289 */   }
/* 290 */
/* 291 */
/* 292 */   public java.lang.Object apply(java.lang.Object _i) {
/* 293 */     InternalRow i = (InternalRow) _i;
/* 294 */
/* 295 */     values = new Object[15];
/* 296 */     apply_0(i);
/* 297 */     apply_1(i);
/* 298 */     apply_2(i);
/* 299 */     apply_3(i);
/* 300 */     apply_4(i);
/* 301 */     apply_5(i);
/* 302 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 303 */     if (false) {
/* 304 */       mutableRow.setNullAt(0);
/* 305 */     } else {
/* 306 */
/* 307 */       mutableRow.update(0, value);
/* 308 */     }
/* 309 */
/* 310 */     return mutableRow;
/* 311 */   }
/* 312 */ }
