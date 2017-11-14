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
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 013 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 014 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 017 */   private scala.collection.Iterator inputadapter_input;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private int agg_value14;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     agg_initAgg = false;
/* 036 */
/* 037 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 038 */
/* 039 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 040 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 041 */     inputadapter_input = inputs[0];
/* 042 */     agg_result = new UnsafeRow(6);
/* 043 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 128);
/* 044 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 6);
/* 045 */
/* 046 */     agg_result1 = new UnsafeRow(7);
/* 047 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 128);
/* 048 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 7);
/* 049 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 050 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 051 */
/* 052 */   }
/* 053 */
/* 054 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 055 */     agg_hashMap = agg_plan.createHashMap();
/* 056 */
/* 057 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 058 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 059 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 060 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 061 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 062 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 063 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 064 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 065 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 066 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 067 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 068 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 069 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 070 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 071 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 072 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 073 */
/* 074 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 075 */
/* 076 */       UnsafeRow agg_fastAggBuffer = null;
/* 077 */
/* 078 */       if (agg_fastAggBuffer == null) {
/* 079 */         // generate grouping key
/* 080 */         agg_holder.reset();
/* 081 */
/* 082 */         agg_rowWriter.zeroOutNullBytes();
/* 083 */
/* 084 */         if (inputadapter_isNull) {
/* 085 */           agg_rowWriter.setNullAt(0);
/* 086 */         } else {
/* 087 */           agg_rowWriter.write(0, inputadapter_value);
/* 088 */         }
/* 089 */
/* 090 */         if (inputadapter_isNull1) {
/* 091 */           agg_rowWriter.setNullAt(1);
/* 092 */         } else {
/* 093 */           agg_rowWriter.write(1, inputadapter_value1);
/* 094 */         }
/* 095 */
/* 096 */         if (inputadapter_isNull2) {
/* 097 */           agg_rowWriter.setNullAt(2);
/* 098 */         } else {
/* 099 */           agg_rowWriter.write(2, inputadapter_value2);
/* 100 */         }
/* 101 */
/* 102 */         if (inputadapter_isNull3) {
/* 103 */           agg_rowWriter.setNullAt(3);
/* 104 */         } else {
/* 105 */           agg_rowWriter.write(3, inputadapter_value3);
/* 106 */         }
/* 107 */
/* 108 */         if (inputadapter_isNull4) {
/* 109 */           agg_rowWriter.setNullAt(4);
/* 110 */         } else {
/* 111 */           agg_rowWriter.write(4, inputadapter_value4);
/* 112 */         }
/* 113 */
/* 114 */         if (inputadapter_isNull5) {
/* 115 */           agg_rowWriter.setNullAt(5);
/* 116 */         } else {
/* 117 */           agg_rowWriter.write(5, inputadapter_value5);
/* 118 */         }
/* 119 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 120 */         agg_value14 = 42;
/* 121 */
/* 122 */         if (!inputadapter_isNull) {
/* 123 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value14);
/* 124 */         }
/* 125 */
/* 126 */         if (!inputadapter_isNull1) {
/* 127 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value14);
/* 128 */         }
/* 129 */
/* 130 */         if (!inputadapter_isNull2) {
/* 131 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value14);
/* 132 */         }
/* 133 */
/* 134 */         if (!inputadapter_isNull3) {
/* 135 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value14);
/* 136 */         }
/* 137 */
/* 138 */         if (!inputadapter_isNull4) {
/* 139 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value14);
/* 140 */         }
/* 141 */
/* 142 */         if (!inputadapter_isNull5) {
/* 143 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value5, agg_value14);
/* 144 */         }
/* 145 */         if (true) {
/* 146 */           // try to get the buffer from hash map
/* 147 */           agg_unsafeRowAggBuffer =
/* 148 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 149 */         }
/* 150 */         if (agg_unsafeRowAggBuffer == null) {
/* 151 */           if (agg_sorter == null) {
/* 152 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 153 */           } else {
/* 154 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 155 */           }
/* 156 */
/* 157 */           // the hash map had be spilled, it should have enough memory now,
/* 158 */           // try  to allocate buffer again.
/* 159 */           agg_unsafeRowAggBuffer =
/* 160 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 161 */           if (agg_unsafeRowAggBuffer == null) {
/* 162 */             // failed to allocate the first page
/* 163 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 164 */           }
/* 165 */         }
/* 166 */       }
/* 167 */
/* 168 */       if (agg_fastAggBuffer != null) {
/* 169 */         // update fast row
/* 170 */
/* 171 */       } else {
/* 172 */         // update unsafe row
/* 173 */
/* 174 */         // common sub-expressions
/* 175 */
/* 176 */         // evaluate aggregate function
/* 177 */         boolean agg_isNull21 = true;
/* 178 */         double agg_value22 = -1.0;
/* 179 */
/* 180 */         boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 181 */         double agg_value24 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 182 */         boolean agg_isNull22 = agg_isNull23;
/* 183 */         double agg_value23 = agg_value24;
/* 184 */         if (agg_isNull22) {
/* 185 */           boolean agg_isNull24 = false;
/* 186 */           double agg_value25 = -1.0;
/* 187 */           if (!false) {
/* 188 */             agg_value25 = (double) 0;
/* 189 */           }
/* 190 */           if (!agg_isNull24) {
/* 191 */             agg_isNull22 = false;
/* 192 */             agg_value23 = agg_value25;
/* 193 */           }
/* 194 */         }
/* 195 */
/* 196 */         if (!inputadapter_isNull6) {
/* 197 */           agg_isNull21 = false; // resultCode could change nullability.
/* 198 */           agg_value22 = agg_value23 + inputadapter_value6;
/* 199 */
/* 200 */         }
/* 201 */         boolean agg_isNull20 = agg_isNull21;
/* 202 */         double agg_value21 = agg_value22;
/* 203 */         if (agg_isNull20) {
/* 204 */           boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 205 */           double agg_value28 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 206 */           if (!agg_isNull27) {
/* 207 */             agg_isNull20 = false;
/* 208 */             agg_value21 = agg_value28;
/* 209 */           }
/* 210 */         }
/* 211 */         // update unsafe row buffer
/* 212 */         if (!agg_isNull20) {
/* 213 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value21);
/* 214 */         } else {
/* 215 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 216 */         }
/* 217 */
/* 218 */       }
/* 219 */       if (shouldStop()) return;
/* 220 */     }
/* 221 */
/* 222 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 223 */   }
/* 224 */
/* 225 */   protected void processNext() throws java.io.IOException {
/* 226 */     if (!agg_initAgg) {
/* 227 */       agg_initAgg = true;
/* 228 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 229 */       agg_doAggregateWithKeys();
/* 230 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 231 */     }
/* 232 */
/* 233 */     // output the result
/* 234 */
/* 235 */     while (agg_mapIter.next()) {
/* 236 */       wholestagecodegen_numOutputRows.add(1);
/* 237 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 238 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 239 */
/* 240 */       boolean agg_isNull28 = agg_aggKey.isNullAt(0);
/* 241 */       UTF8String agg_value29 = agg_isNull28 ? null : (agg_aggKey.getUTF8String(0));
/* 242 */       boolean agg_isNull29 = agg_aggKey.isNullAt(1);
/* 243 */       UTF8String agg_value30 = agg_isNull29 ? null : (agg_aggKey.getUTF8String(1));
/* 244 */       boolean agg_isNull30 = agg_aggKey.isNullAt(2);
/* 245 */       UTF8String agg_value31 = agg_isNull30 ? null : (agg_aggKey.getUTF8String(2));
/* 246 */       boolean agg_isNull31 = agg_aggKey.isNullAt(3);
/* 247 */       UTF8String agg_value32 = agg_isNull31 ? null : (agg_aggKey.getUTF8String(3));
/* 248 */       boolean agg_isNull32 = agg_aggKey.isNullAt(4);
/* 249 */       int agg_value33 = agg_isNull32 ? -1 : (agg_aggKey.getInt(4));
/* 250 */       boolean agg_isNull33 = agg_aggKey.isNullAt(5);
/* 251 */       int agg_value34 = agg_isNull33 ? -1 : (agg_aggKey.getInt(5));
/* 252 */       boolean agg_isNull34 = agg_aggBuffer.isNullAt(0);
/* 253 */       double agg_value35 = agg_isNull34 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 254 */
/* 255 */       agg_holder1.reset();
/* 256 */
/* 257 */       agg_rowWriter1.zeroOutNullBytes();
/* 258 */
/* 259 */       if (agg_isNull28) {
/* 260 */         agg_rowWriter1.setNullAt(0);
/* 261 */       } else {
/* 262 */         agg_rowWriter1.write(0, agg_value29);
/* 263 */       }
/* 264 */
/* 265 */       if (agg_isNull29) {
/* 266 */         agg_rowWriter1.setNullAt(1);
/* 267 */       } else {
/* 268 */         agg_rowWriter1.write(1, agg_value30);
/* 269 */       }
/* 270 */
/* 271 */       if (agg_isNull30) {
/* 272 */         agg_rowWriter1.setNullAt(2);
/* 273 */       } else {
/* 274 */         agg_rowWriter1.write(2, agg_value31);
/* 275 */       }
/* 276 */
/* 277 */       if (agg_isNull31) {
/* 278 */         agg_rowWriter1.setNullAt(3);
/* 279 */       } else {
/* 280 */         agg_rowWriter1.write(3, agg_value32);
/* 281 */       }
/* 282 */
/* 283 */       if (agg_isNull32) {
/* 284 */         agg_rowWriter1.setNullAt(4);
/* 285 */       } else {
/* 286 */         agg_rowWriter1.write(4, agg_value33);
/* 287 */       }
/* 288 */
/* 289 */       if (agg_isNull33) {
/* 290 */         agg_rowWriter1.setNullAt(5);
/* 291 */       } else {
/* 292 */         agg_rowWriter1.write(5, agg_value34);
/* 293 */       }
/* 294 */
/* 295 */       if (agg_isNull34) {
/* 296 */         agg_rowWriter1.setNullAt(6);
/* 297 */       } else {
/* 298 */         agg_rowWriter1.write(6, agg_value35);
/* 299 */       }
/* 300 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 301 */       append(agg_result1);
/* 302 */
/* 303 */       if (shouldStop()) return;
/* 304 */     }
/* 305 */
/* 306 */     agg_mapIter.close();
/* 307 */     if (agg_sorter == null) {
/* 308 */       agg_hashMap.free();
/* 309 */     }
/* 310 */   }
/* 311 */ }
