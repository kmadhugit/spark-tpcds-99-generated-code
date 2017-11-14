/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private int agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private int agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private int agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private int agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private int agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private int agg_bufValue7;
/* 025 */   private boolean agg_bufIsNull8;
/* 026 */   private int agg_bufValue8;
/* 027 */   private boolean agg_bufIsNull9;
/* 028 */   private int agg_bufValue9;
/* 029 */   private boolean agg_bufIsNull10;
/* 030 */   private int agg_bufValue10;
/* 031 */   private boolean agg_bufIsNull11;
/* 032 */   private long agg_bufValue11;
/* 033 */   private scala.collection.Iterator inputadapter_input;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 036 */   private UnsafeRow agg_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 039 */
/* 040 */   public GeneratedIterator(Object[] references) {
/* 041 */     this.references = references;
/* 042 */   }
/* 043 */
/* 044 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 045 */     partitionIndex = index;
/* 046 */     this.inputs = inputs;
/* 047 */     agg_initAgg = false;
/* 048 */
/* 049 */     inputadapter_input = inputs[0];
/* 050 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 051 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 052 */     agg_result = new UnsafeRow(12);
/* 053 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 054 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 12);
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 059 */     // initialize aggregation buffer
/* 060 */     agg_bufIsNull = false;
/* 061 */     agg_bufValue = 0L;
/* 062 */     agg_bufIsNull1 = false;
/* 063 */     agg_bufValue1 = 0L;
/* 064 */     final int agg_value2 = -1;
/* 065 */     agg_bufIsNull2 = true;
/* 066 */     agg_bufValue2 = agg_value2;
/* 067 */     final int agg_value3 = -1;
/* 068 */     agg_bufIsNull3 = true;
/* 069 */     agg_bufValue3 = agg_value3;
/* 070 */     final int agg_value4 = -1;
/* 071 */     agg_bufIsNull4 = true;
/* 072 */     agg_bufValue4 = agg_value4;
/* 073 */     final int agg_value5 = -1;
/* 074 */     agg_bufIsNull5 = true;
/* 075 */     agg_bufValue5 = agg_value5;
/* 076 */     final int agg_value6 = -1;
/* 077 */     agg_bufIsNull6 = true;
/* 078 */     agg_bufValue6 = agg_value6;
/* 079 */     final int agg_value7 = -1;
/* 080 */     agg_bufIsNull7 = true;
/* 081 */     agg_bufValue7 = agg_value7;
/* 082 */     final int agg_value8 = -1;
/* 083 */     agg_bufIsNull8 = true;
/* 084 */     agg_bufValue8 = agg_value8;
/* 085 */     final int agg_value9 = -1;
/* 086 */     agg_bufIsNull9 = true;
/* 087 */     agg_bufValue9 = agg_value9;
/* 088 */     final int agg_value10 = -1;
/* 089 */     agg_bufIsNull10 = true;
/* 090 */     agg_bufValue10 = agg_value10;
/* 091 */     agg_bufIsNull11 = false;
/* 092 */     agg_bufValue11 = 0L;
/* 093 */
/* 094 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 095 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 096 */       long inputadapter_value = inputadapter_row.getLong(0);
/* 097 */       long inputadapter_value1 = inputadapter_row.getLong(1);
/* 098 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 099 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 100 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 101 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 102 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 103 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 104 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 105 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 106 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 107 */       int inputadapter_value6 = inputadapter_isNull6 ? -1 : (inputadapter_row.getInt(6));
/* 108 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 109 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 110 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 111 */       int inputadapter_value8 = inputadapter_isNull8 ? -1 : (inputadapter_row.getInt(8));
/* 112 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 113 */       int inputadapter_value9 = inputadapter_isNull9 ? -1 : (inputadapter_row.getInt(9));
/* 114 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 115 */       int inputadapter_value10 = inputadapter_isNull10 ? -1 : (inputadapter_row.getInt(10));
/* 116 */       long inputadapter_value11 = inputadapter_row.getLong(11);
/* 117 */
/* 118 */       // do aggregate
/* 119 */       // common sub-expressions
/* 120 */
/* 121 */       // evaluate aggregate function
/* 122 */       boolean agg_isNull36 = false;
/* 123 */
/* 124 */       long agg_value36 = -1L;
/* 125 */       agg_value36 = agg_bufValue + inputadapter_value;
/* 126 */       boolean agg_isNull39 = false;
/* 127 */
/* 128 */       long agg_value39 = -1L;
/* 129 */       agg_value39 = agg_bufValue1 + inputadapter_value1;
/* 130 */       boolean agg_isNull42 = agg_bufIsNull2;
/* 131 */       int agg_value42 = agg_bufValue2;
/* 132 */
/* 133 */       if (!inputadapter_isNull2 && (agg_isNull42 ||
/* 134 */           inputadapter_value2 > agg_value42)) {
/* 135 */         agg_isNull42 = false;
/* 136 */         agg_value42 = inputadapter_value2;
/* 137 */       }
/* 138 */       boolean agg_isNull45 = agg_bufIsNull3;
/* 139 */       int agg_value45 = agg_bufValue3;
/* 140 */
/* 141 */       if (!inputadapter_isNull3 && (agg_isNull45 ||
/* 142 */           inputadapter_value3 > agg_value45)) {
/* 143 */         agg_isNull45 = false;
/* 144 */         agg_value45 = inputadapter_value3;
/* 145 */       }
/* 146 */       boolean agg_isNull48 = agg_bufIsNull4;
/* 147 */       int agg_value48 = agg_bufValue4;
/* 148 */
/* 149 */       if (!inputadapter_isNull4 && (agg_isNull48 ||
/* 150 */           inputadapter_value4 > agg_value48)) {
/* 151 */         agg_isNull48 = false;
/* 152 */         agg_value48 = inputadapter_value4;
/* 153 */       }
/* 154 */       boolean agg_isNull51 = agg_bufIsNull5;
/* 155 */       int agg_value51 = agg_bufValue5;
/* 156 */
/* 157 */       if (!inputadapter_isNull5 && (agg_isNull51 ||
/* 158 */           inputadapter_value5 > agg_value51)) {
/* 159 */         agg_isNull51 = false;
/* 160 */         agg_value51 = inputadapter_value5;
/* 161 */       }
/* 162 */       boolean agg_isNull54 = agg_bufIsNull6;
/* 163 */       int agg_value54 = agg_bufValue6;
/* 164 */
/* 165 */       if (!inputadapter_isNull6 && (agg_isNull54 ||
/* 166 */           inputadapter_value6 > agg_value54)) {
/* 167 */         agg_isNull54 = false;
/* 168 */         agg_value54 = inputadapter_value6;
/* 169 */       }
/* 170 */       boolean agg_isNull57 = agg_bufIsNull7;
/* 171 */       int agg_value57 = agg_bufValue7;
/* 172 */
/* 173 */       if (!inputadapter_isNull7 && (agg_isNull57 ||
/* 174 */           inputadapter_value7 > agg_value57)) {
/* 175 */         agg_isNull57 = false;
/* 176 */         agg_value57 = inputadapter_value7;
/* 177 */       }
/* 178 */       boolean agg_isNull60 = agg_bufIsNull8;
/* 179 */       int agg_value60 = agg_bufValue8;
/* 180 */
/* 181 */       if (!inputadapter_isNull8 && (agg_isNull60 ||
/* 182 */           inputadapter_value8 > agg_value60)) {
/* 183 */         agg_isNull60 = false;
/* 184 */         agg_value60 = inputadapter_value8;
/* 185 */       }
/* 186 */       boolean agg_isNull63 = agg_bufIsNull9;
/* 187 */       int agg_value63 = agg_bufValue9;
/* 188 */
/* 189 */       if (!inputadapter_isNull9 && (agg_isNull63 ||
/* 190 */           inputadapter_value9 > agg_value63)) {
/* 191 */         agg_isNull63 = false;
/* 192 */         agg_value63 = inputadapter_value9;
/* 193 */       }
/* 194 */       boolean agg_isNull66 = agg_bufIsNull10;
/* 195 */       int agg_value66 = agg_bufValue10;
/* 196 */
/* 197 */       if (!inputadapter_isNull10 && (agg_isNull66 ||
/* 198 */           inputadapter_value10 > agg_value66)) {
/* 199 */         agg_isNull66 = false;
/* 200 */         agg_value66 = inputadapter_value10;
/* 201 */       }
/* 202 */       boolean agg_isNull69 = false;
/* 203 */
/* 204 */       long agg_value69 = -1L;
/* 205 */       agg_value69 = agg_bufValue11 + inputadapter_value11;
/* 206 */       // update aggregation buffer
/* 207 */       agg_bufIsNull = false;
/* 208 */       agg_bufValue = agg_value36;
/* 209 */
/* 210 */       agg_bufIsNull1 = false;
/* 211 */       agg_bufValue1 = agg_value39;
/* 212 */
/* 213 */       agg_bufIsNull2 = agg_isNull42;
/* 214 */       agg_bufValue2 = agg_value42;
/* 215 */
/* 216 */       agg_bufIsNull3 = agg_isNull45;
/* 217 */       agg_bufValue3 = agg_value45;
/* 218 */
/* 219 */       agg_bufIsNull4 = agg_isNull48;
/* 220 */       agg_bufValue4 = agg_value48;
/* 221 */
/* 222 */       agg_bufIsNull5 = agg_isNull51;
/* 223 */       agg_bufValue5 = agg_value51;
/* 224 */
/* 225 */       agg_bufIsNull6 = agg_isNull54;
/* 226 */       agg_bufValue6 = agg_value54;
/* 227 */
/* 228 */       agg_bufIsNull7 = agg_isNull57;
/* 229 */       agg_bufValue7 = agg_value57;
/* 230 */
/* 231 */       agg_bufIsNull8 = agg_isNull60;
/* 232 */       agg_bufValue8 = agg_value60;
/* 233 */
/* 234 */       agg_bufIsNull9 = agg_isNull63;
/* 235 */       agg_bufValue9 = agg_value63;
/* 236 */
/* 237 */       agg_bufIsNull10 = agg_isNull66;
/* 238 */       agg_bufValue10 = agg_value66;
/* 239 */
/* 240 */       agg_bufIsNull11 = false;
/* 241 */       agg_bufValue11 = agg_value69;
/* 242 */       if (shouldStop()) return;
/* 243 */     }
/* 244 */
/* 245 */   }
/* 246 */
/* 247 */   protected void processNext() throws java.io.IOException {
/* 248 */     while (!agg_initAgg) {
/* 249 */       agg_initAgg = true;
/* 250 */       long agg_beforeAgg = System.nanoTime();
/* 251 */       agg_doAggregateWithoutKey();
/* 252 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 253 */
/* 254 */       // output the result
/* 255 */
/* 256 */       agg_numOutputRows.add(1);
/* 257 */       agg_rowWriter.zeroOutNullBytes();
/* 258 */
/* 259 */       if (agg_bufIsNull) {
/* 260 */         agg_rowWriter.setNullAt(0);
/* 261 */       } else {
/* 262 */         agg_rowWriter.write(0, agg_bufValue);
/* 263 */       }
/* 264 */
/* 265 */       if (agg_bufIsNull1) {
/* 266 */         agg_rowWriter.setNullAt(1);
/* 267 */       } else {
/* 268 */         agg_rowWriter.write(1, agg_bufValue1);
/* 269 */       }
/* 270 */
/* 271 */       if (agg_bufIsNull11) {
/* 272 */         agg_rowWriter.setNullAt(2);
/* 273 */       } else {
/* 274 */         agg_rowWriter.write(2, agg_bufValue11);
/* 275 */       }
/* 276 */
/* 277 */       if (agg_bufIsNull2) {
/* 278 */         agg_rowWriter.setNullAt(3);
/* 279 */       } else {
/* 280 */         agg_rowWriter.write(3, agg_bufValue2);
/* 281 */       }
/* 282 */
/* 283 */       if (agg_bufIsNull3) {
/* 284 */         agg_rowWriter.setNullAt(4);
/* 285 */       } else {
/* 286 */         agg_rowWriter.write(4, agg_bufValue3);
/* 287 */       }
/* 288 */
/* 289 */       if (agg_bufIsNull4) {
/* 290 */         agg_rowWriter.setNullAt(5);
/* 291 */       } else {
/* 292 */         agg_rowWriter.write(5, agg_bufValue4);
/* 293 */       }
/* 294 */
/* 295 */       if (agg_bufIsNull5) {
/* 296 */         agg_rowWriter.setNullAt(6);
/* 297 */       } else {
/* 298 */         agg_rowWriter.write(6, agg_bufValue5);
/* 299 */       }
/* 300 */
/* 301 */       if (agg_bufIsNull6) {
/* 302 */         agg_rowWriter.setNullAt(7);
/* 303 */       } else {
/* 304 */         agg_rowWriter.write(7, agg_bufValue6);
/* 305 */       }
/* 306 */
/* 307 */       if (agg_bufIsNull7) {
/* 308 */         agg_rowWriter.setNullAt(8);
/* 309 */       } else {
/* 310 */         agg_rowWriter.write(8, agg_bufValue7);
/* 311 */       }
/* 312 */
/* 313 */       if (agg_bufIsNull8) {
/* 314 */         agg_rowWriter.setNullAt(9);
/* 315 */       } else {
/* 316 */         agg_rowWriter.write(9, agg_bufValue8);
/* 317 */       }
/* 318 */
/* 319 */       if (agg_bufIsNull9) {
/* 320 */         agg_rowWriter.setNullAt(10);
/* 321 */       } else {
/* 322 */         agg_rowWriter.write(10, agg_bufValue9);
/* 323 */       }
/* 324 */
/* 325 */       if (agg_bufIsNull10) {
/* 326 */         agg_rowWriter.setNullAt(11);
/* 327 */       } else {
/* 328 */         agg_rowWriter.write(11, agg_bufValue10);
/* 329 */       }
/* 330 */       append(agg_result);
/* 331 */     }
/* 332 */   }
/* 333 */ }
