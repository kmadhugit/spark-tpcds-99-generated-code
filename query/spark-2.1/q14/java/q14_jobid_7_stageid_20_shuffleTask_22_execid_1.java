/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private UnsafeRow result;
/* 009 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 011 */
/* 012 */   public SpecificUnsafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     result = new UnsafeRow(23);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 23);
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
/* 027 */
/* 028 */     boolean isNull18 = i.isNullAt(18);
/* 029 */     double value18 = isNull18 ? -1.0 : (i.getDouble(18));
/* 030 */     if (isNull18) {
/* 031 */       rowWriter.setNullAt(18);
/* 032 */     } else {
/* 033 */       rowWriter.write(18, value18);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull19 = i.isNullAt(19);
/* 038 */     double value19 = isNull19 ? -1.0 : (i.getDouble(19));
/* 039 */     if (isNull19) {
/* 040 */       rowWriter.setNullAt(19);
/* 041 */     } else {
/* 042 */       rowWriter.write(19, value19);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     boolean isNull20 = i.isNullAt(20);
/* 047 */     double value20 = isNull20 ? -1.0 : (i.getDouble(20));
/* 048 */     if (isNull20) {
/* 049 */       rowWriter.setNullAt(20);
/* 050 */     } else {
/* 051 */       rowWriter.write(20, value20);
/* 052 */     }
/* 053 */
/* 054 */
/* 055 */     boolean isNull21 = i.isNullAt(21);
/* 056 */     double value21 = isNull21 ? -1.0 : (i.getDouble(21));
/* 057 */     if (isNull21) {
/* 058 */       rowWriter.setNullAt(21);
/* 059 */     } else {
/* 060 */       rowWriter.write(21, value21);
/* 061 */     }
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */
/* 066 */   private void apply_1(InternalRow i) {
/* 067 */
/* 068 */
/* 069 */     boolean isNull5 = i.isNullAt(5);
/* 070 */     int value5 = isNull5 ? -1 : (i.getInt(5));
/* 071 */     if (isNull5) {
/* 072 */       rowWriter.setNullAt(5);
/* 073 */     } else {
/* 074 */       rowWriter.write(5, value5);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     boolean isNull6 = i.isNullAt(6);
/* 079 */     int value6 = isNull6 ? -1 : (i.getInt(6));
/* 080 */     if (isNull6) {
/* 081 */       rowWriter.setNullAt(6);
/* 082 */     } else {
/* 083 */       rowWriter.write(6, value6);
/* 084 */     }
/* 085 */
/* 086 */
/* 087 */     boolean isNull7 = i.isNullAt(7);
/* 088 */     int value7 = isNull7 ? -1 : (i.getInt(7));
/* 089 */     if (isNull7) {
/* 090 */       rowWriter.setNullAt(7);
/* 091 */     } else {
/* 092 */       rowWriter.write(7, value7);
/* 093 */     }
/* 094 */
/* 095 */
/* 096 */     boolean isNull8 = i.isNullAt(8);
/* 097 */     int value8 = isNull8 ? -1 : (i.getInt(8));
/* 098 */     if (isNull8) {
/* 099 */       rowWriter.setNullAt(8);
/* 100 */     } else {
/* 101 */       rowWriter.write(8, value8);
/* 102 */     }
/* 103 */
/* 104 */
/* 105 */     boolean isNull9 = i.isNullAt(9);
/* 106 */     int value9 = isNull9 ? -1 : (i.getInt(9));
/* 107 */     if (isNull9) {
/* 108 */       rowWriter.setNullAt(9);
/* 109 */     } else {
/* 110 */       rowWriter.write(9, value9);
/* 111 */     }
/* 112 */
/* 113 */   }
/* 114 */
/* 115 */
/* 116 */   private void apply_3(InternalRow i) {
/* 117 */
/* 118 */
/* 119 */     boolean isNull14 = i.isNullAt(14);
/* 120 */     double value14 = isNull14 ? -1.0 : (i.getDouble(14));
/* 121 */     if (isNull14) {
/* 122 */       rowWriter.setNullAt(14);
/* 123 */     } else {
/* 124 */       rowWriter.write(14, value14);
/* 125 */     }
/* 126 */
/* 127 */
/* 128 */     boolean isNull15 = i.isNullAt(15);
/* 129 */     double value15 = isNull15 ? -1.0 : (i.getDouble(15));
/* 130 */     if (isNull15) {
/* 131 */       rowWriter.setNullAt(15);
/* 132 */     } else {
/* 133 */       rowWriter.write(15, value15);
/* 134 */     }
/* 135 */
/* 136 */
/* 137 */     boolean isNull16 = i.isNullAt(16);
/* 138 */     double value16 = isNull16 ? -1.0 : (i.getDouble(16));
/* 139 */     if (isNull16) {
/* 140 */       rowWriter.setNullAt(16);
/* 141 */     } else {
/* 142 */       rowWriter.write(16, value16);
/* 143 */     }
/* 144 */
/* 145 */
/* 146 */     boolean isNull17 = i.isNullAt(17);
/* 147 */     double value17 = isNull17 ? -1.0 : (i.getDouble(17));
/* 148 */     if (isNull17) {
/* 149 */       rowWriter.setNullAt(17);
/* 150 */     } else {
/* 151 */       rowWriter.write(17, value17);
/* 152 */     }
/* 153 */
/* 154 */   }
/* 155 */
/* 156 */
/* 157 */   private void apply_0(InternalRow i) {
/* 158 */
/* 159 */
/* 160 */     boolean isNull = i.isNullAt(0);
/* 161 */     int value = isNull ? -1 : (i.getInt(0));
/* 162 */     if (isNull) {
/* 163 */       rowWriter.setNullAt(0);
/* 164 */     } else {
/* 165 */       rowWriter.write(0, value);
/* 166 */     }
/* 167 */
/* 168 */
/* 169 */     boolean isNull1 = i.isNullAt(1);
/* 170 */     int value1 = isNull1 ? -1 : (i.getInt(1));
/* 171 */     if (isNull1) {
/* 172 */       rowWriter.setNullAt(1);
/* 173 */     } else {
/* 174 */       rowWriter.write(1, value1);
/* 175 */     }
/* 176 */
/* 177 */
/* 178 */     boolean isNull2 = i.isNullAt(2);
/* 179 */     int value2 = isNull2 ? -1 : (i.getInt(2));
/* 180 */     if (isNull2) {
/* 181 */       rowWriter.setNullAt(2);
/* 182 */     } else {
/* 183 */       rowWriter.write(2, value2);
/* 184 */     }
/* 185 */
/* 186 */
/* 187 */     boolean isNull3 = i.isNullAt(3);
/* 188 */     int value3 = isNull3 ? -1 : (i.getInt(3));
/* 189 */     if (isNull3) {
/* 190 */       rowWriter.setNullAt(3);
/* 191 */     } else {
/* 192 */       rowWriter.write(3, value3);
/* 193 */     }
/* 194 */
/* 195 */
/* 196 */     boolean isNull4 = i.isNullAt(4);
/* 197 */     int value4 = isNull4 ? -1 : (i.getInt(4));
/* 198 */     if (isNull4) {
/* 199 */       rowWriter.setNullAt(4);
/* 200 */     } else {
/* 201 */       rowWriter.write(4, value4);
/* 202 */     }
/* 203 */
/* 204 */   }
/* 205 */
/* 206 */
/* 207 */   private void apply_2(InternalRow i) {
/* 208 */
/* 209 */
/* 210 */     boolean isNull10 = i.isNullAt(10);
/* 211 */     double value10 = isNull10 ? -1.0 : (i.getDouble(10));
/* 212 */     if (isNull10) {
/* 213 */       rowWriter.setNullAt(10);
/* 214 */     } else {
/* 215 */       rowWriter.write(10, value10);
/* 216 */     }
/* 217 */
/* 218 */
/* 219 */     boolean isNull11 = i.isNullAt(11);
/* 220 */     double value11 = isNull11 ? -1.0 : (i.getDouble(11));
/* 221 */     if (isNull11) {
/* 222 */       rowWriter.setNullAt(11);
/* 223 */     } else {
/* 224 */       rowWriter.write(11, value11);
/* 225 */     }
/* 226 */
/* 227 */
/* 228 */     boolean isNull12 = i.isNullAt(12);
/* 229 */     double value12 = isNull12 ? -1.0 : (i.getDouble(12));
/* 230 */     if (isNull12) {
/* 231 */       rowWriter.setNullAt(12);
/* 232 */     } else {
/* 233 */       rowWriter.write(12, value12);
/* 234 */     }
/* 235 */
/* 236 */
/* 237 */     boolean isNull13 = i.isNullAt(13);
/* 238 */     double value13 = isNull13 ? -1.0 : (i.getDouble(13));
/* 239 */     if (isNull13) {
/* 240 */       rowWriter.setNullAt(13);
/* 241 */     } else {
/* 242 */       rowWriter.write(13, value13);
/* 243 */     }
/* 244 */
/* 245 */   }
/* 246 */
/* 247 */
/* 248 */   private void apply_5(InternalRow i) {
/* 249 */
/* 250 */
/* 251 */     boolean isNull22 = i.isNullAt(22);
/* 252 */     int value22 = isNull22 ? -1 : (i.getInt(22));
/* 253 */     if (isNull22) {
/* 254 */       rowWriter.setNullAt(22);
/* 255 */     } else {
/* 256 */       rowWriter.write(22, value22);
/* 257 */     }
/* 258 */
/* 259 */   }
/* 260 */
/* 261 */
/* 262 */   // Scala.Function1 need this
/* 263 */   public java.lang.Object apply(java.lang.Object row) {
/* 264 */     return apply((InternalRow) row);
/* 265 */   }
/* 266 */
/* 267 */   public UnsafeRow apply(InternalRow i) {
/* 268 */     rowWriter.zeroOutNullBytes();
/* 269 */     apply_0(i);
/* 270 */     apply_1(i);
/* 271 */     apply_2(i);
/* 272 */     apply_3(i);
/* 273 */     apply_4(i);
/* 274 */     apply_5(i);
/* 275 */     return result;
/* 276 */   }
/* 277 */ }
