/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private double agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 016 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 017 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 018 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 021 */   private scala.collection.Iterator inputadapter_input;
/* 022 */   private UnsafeRow agg_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 025 */   private int agg_value8;
/* 026 */   private UnsafeRow agg_result1;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 031 */
/* 032 */   public GeneratedIterator(Object[] references) {
/* 033 */     this.references = references;
/* 034 */   }
/* 035 */
/* 036 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 037 */     partitionIndex = index;
/* 038 */     this.inputs = inputs;
/* 039 */     agg_initAgg = false;
/* 040 */
/* 041 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 042 */
/* 043 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 045 */     inputadapter_input = inputs[0];
/* 046 */     agg_result = new UnsafeRow(1);
/* 047 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 048 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 049 */
/* 050 */     agg_result1 = new UnsafeRow(5);
/* 051 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 052 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
/* 053 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 054 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 059 */     agg_hashMap = agg_plan.createHashMap();
/* 060 */
/* 061 */     while (inputadapter_input.hasNext()) {
/* 062 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 063 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 064 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 065 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 066 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 067 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 068 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 069 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 070 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 071 */
/* 072 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 073 */
/* 074 */       UnsafeRow agg_fastAggBuffer = null;
/* 075 */
/* 076 */       if (agg_fastAggBuffer == null) {
/* 077 */         // generate grouping key
/* 078 */         agg_holder.reset();
/* 079 */
/* 080 */         agg_rowWriter.zeroOutNullBytes();
/* 081 */
/* 082 */         if (inputadapter_isNull) {
/* 083 */           agg_rowWriter.setNullAt(0);
/* 084 */         } else {
/* 085 */           agg_rowWriter.write(0, inputadapter_value);
/* 086 */         }
/* 087 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 088 */         agg_value8 = 42;
/* 089 */
/* 090 */         if (!inputadapter_isNull) {
/* 091 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value8);
/* 092 */         }
/* 093 */         if (true) {
/* 094 */           // try to get the buffer from hash map
/* 095 */           agg_unsafeRowAggBuffer =
/* 096 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value8);
/* 097 */         }
/* 098 */         if (agg_unsafeRowAggBuffer == null) {
/* 099 */           if (agg_sorter == null) {
/* 100 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 101 */           } else {
/* 102 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 103 */           }
/* 104 */
/* 105 */           // the hash map had be spilled, it should have enough memory now,
/* 106 */           // try  to allocate buffer again.
/* 107 */           agg_unsafeRowAggBuffer =
/* 108 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value8);
/* 109 */           if (agg_unsafeRowAggBuffer == null) {
/* 110 */             // failed to allocate the first page
/* 111 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 112 */           }
/* 113 */         }
/* 114 */       }
/* 115 */
/* 116 */       if (agg_fastAggBuffer != null) {
/* 117 */         // update fast row
/* 118 */
/* 119 */       } else {
/* 120 */         // update unsafe row
/* 121 */
/* 122 */         // common sub-expressions
/* 123 */         boolean agg_isNull7 = false;
/* 124 */         double agg_value10 = -1.0;
/* 125 */         if (!false) {
/* 126 */           agg_value10 = (double) 0;
/* 127 */         }
/* 128 */         // evaluate aggregate function
/* 129 */         boolean agg_isNull10 = true;
/* 130 */         double agg_value13 = -1.0;
/* 131 */
/* 132 */         boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 133 */         double agg_value15 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 134 */         boolean agg_isNull11 = agg_isNull12;
/* 135 */         double agg_value14 = agg_value15;
/* 136 */         if (agg_isNull11) {
/* 137 */           if (!agg_isNull7) {
/* 138 */             agg_isNull11 = false;
/* 139 */             agg_value14 = agg_value10;
/* 140 */           }
/* 141 */         }
/* 142 */
/* 143 */         if (!inputadapter_isNull1) {
/* 144 */           agg_isNull10 = false; // resultCode could change nullability.
/* 145 */           agg_value13 = agg_value14 + inputadapter_value1;
/* 146 */
/* 147 */         }
/* 148 */         boolean agg_isNull9 = agg_isNull10;
/* 149 */         double agg_value12 = agg_value13;
/* 150 */         if (agg_isNull9) {
/* 151 */           boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 152 */           double agg_value17 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 153 */           if (!agg_isNull14) {
/* 154 */             agg_isNull9 = false;
/* 155 */             agg_value12 = agg_value17;
/* 156 */           }
/* 157 */         }
/* 158 */         boolean agg_isNull16 = true;
/* 159 */         double agg_value19 = -1.0;
/* 160 */
/* 161 */         boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 162 */         double agg_value21 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 163 */         boolean agg_isNull17 = agg_isNull18;
/* 164 */         double agg_value20 = agg_value21;
/* 165 */         if (agg_isNull17) {
/* 166 */           if (!agg_isNull7) {
/* 167 */             agg_isNull17 = false;
/* 168 */             agg_value20 = agg_value10;
/* 169 */           }
/* 170 */         }
/* 171 */
/* 172 */         if (!inputadapter_isNull2) {
/* 173 */           agg_isNull16 = false; // resultCode could change nullability.
/* 174 */           agg_value19 = agg_value20 + inputadapter_value2;
/* 175 */
/* 176 */         }
/* 177 */         boolean agg_isNull15 = agg_isNull16;
/* 178 */         double agg_value18 = agg_value19;
/* 179 */         if (agg_isNull15) {
/* 180 */           boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 181 */           double agg_value23 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 182 */           if (!agg_isNull20) {
/* 183 */             agg_isNull15 = false;
/* 184 */             agg_value18 = agg_value23;
/* 185 */           }
/* 186 */         }
/* 187 */         boolean agg_isNull22 = true;
/* 188 */         double agg_value25 = -1.0;
/* 189 */
/* 190 */         boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 191 */         double agg_value27 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 192 */         boolean agg_isNull23 = agg_isNull24;
/* 193 */         double agg_value26 = agg_value27;
/* 194 */         if (agg_isNull23) {
/* 195 */           if (!agg_isNull7) {
/* 196 */             agg_isNull23 = false;
/* 197 */             agg_value26 = agg_value10;
/* 198 */           }
/* 199 */         }
/* 200 */
/* 201 */         if (!inputadapter_isNull3) {
/* 202 */           agg_isNull22 = false; // resultCode could change nullability.
/* 203 */           agg_value25 = agg_value26 + inputadapter_value3;
/* 204 */
/* 205 */         }
/* 206 */         boolean agg_isNull21 = agg_isNull22;
/* 207 */         double agg_value24 = agg_value25;
/* 208 */         if (agg_isNull21) {
/* 209 */           boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 210 */           double agg_value29 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 211 */           if (!agg_isNull26) {
/* 212 */             agg_isNull21 = false;
/* 213 */             agg_value24 = agg_value29;
/* 214 */           }
/* 215 */         }
/* 216 */         // update unsafe row buffer
/* 217 */         if (!agg_isNull9) {
/* 218 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value12);
/* 219 */         } else {
/* 220 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 221 */         }
/* 222 */
/* 223 */         if (!agg_isNull15) {
/* 224 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value18);
/* 225 */         } else {
/* 226 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 227 */         }
/* 228 */
/* 229 */         if (!agg_isNull21) {
/* 230 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value24);
/* 231 */         } else {
/* 232 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 233 */         }
/* 234 */
/* 235 */       }
/* 236 */       if (shouldStop()) return;
/* 237 */     }
/* 238 */
/* 239 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 240 */   }
/* 241 */
/* 242 */   protected void processNext() throws java.io.IOException {
/* 243 */     if (!agg_initAgg) {
/* 244 */       agg_initAgg = true;
/* 245 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 246 */       agg_doAggregateWithKeys();
/* 247 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 248 */     }
/* 249 */
/* 250 */     // output the result
/* 251 */
/* 252 */     while (agg_mapIter.next()) {
/* 253 */       wholestagecodegen_numOutputRows.add(1);
/* 254 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 255 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 256 */
/* 257 */       boolean agg_isNull27 = agg_aggKey.isNullAt(0);
/* 258 */       UTF8String agg_value30 = agg_isNull27 ? null : (agg_aggKey.getUTF8String(0));
/* 259 */       boolean agg_isNull28 = agg_aggBuffer.isNullAt(0);
/* 260 */       double agg_value31 = agg_isNull28 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 261 */       boolean agg_isNull29 = agg_aggBuffer.isNullAt(1);
/* 262 */       double agg_value32 = agg_isNull29 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 263 */       boolean agg_isNull30 = agg_aggBuffer.isNullAt(2);
/* 264 */       double agg_value33 = agg_isNull30 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 265 */
/* 266 */       Object agg_obj = ((Expression) references[3]).eval(null);
/* 267 */       UTF8String agg_value40 = (UTF8String) agg_obj;
/* 268 */       Object agg_obj1 = ((Expression) references[4]).eval(null);
/* 269 */       UTF8String agg_value42 = (UTF8String) agg_obj1;
/* 270 */
/* 271 */       boolean agg_isNull38 = false;
/* 272 */       UTF8String agg_value41 = UTF8String.concat(false ? null : agg_value42, agg_isNull27 ? null : agg_value30);
/* 273 */       if (agg_value41 == null) {
/* 274 */         agg_isNull38 = true;
/* 275 */       }
/* 276 */       agg_holder1.reset();
/* 277 */
/* 278 */       agg_rowWriter1.zeroOutNullBytes();
/* 279 */
/* 280 */       if (agg_isNull28) {
/* 281 */         agg_rowWriter1.setNullAt(0);
/* 282 */       } else {
/* 283 */         agg_rowWriter1.write(0, agg_value31);
/* 284 */       }
/* 285 */
/* 286 */       if (agg_isNull29) {
/* 287 */         agg_rowWriter1.setNullAt(1);
/* 288 */       } else {
/* 289 */         agg_rowWriter1.write(1, agg_value32);
/* 290 */       }
/* 291 */
/* 292 */       if (agg_isNull30) {
/* 293 */         agg_rowWriter1.setNullAt(2);
/* 294 */       } else {
/* 295 */         agg_rowWriter1.write(2, agg_value33);
/* 296 */       }
/* 297 */
/* 298 */       agg_rowWriter1.write(3, agg_value40);
/* 299 */
/* 300 */       if (agg_isNull38) {
/* 301 */         agg_rowWriter1.setNullAt(4);
/* 302 */       } else {
/* 303 */         agg_rowWriter1.write(4, agg_value41);
/* 304 */       }
/* 305 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 306 */       append(agg_result1);
/* 307 */
/* 308 */       if (shouldStop()) return;
/* 309 */     }
/* 310 */
/* 311 */     agg_mapIter.close();
/* 312 */     if (agg_sorter == null) {
/* 313 */       agg_hashMap.free();
/* 314 */     }
/* 315 */   }
/* 316 */ }
