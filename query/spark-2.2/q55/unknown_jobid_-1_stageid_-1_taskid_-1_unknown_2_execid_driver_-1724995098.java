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
/* 021 */   private int agg_value6;
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
/* 042 */     agg_result = new UnsafeRow(2);
/* 043 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 044 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 045 */
/* 046 */     agg_result1 = new UnsafeRow(3);
/* 047 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 048 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
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
/* 062 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 063 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 064 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 065 */
/* 066 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 067 */
/* 068 */       UnsafeRow agg_fastAggBuffer = null;
/* 069 */
/* 070 */       if (agg_fastAggBuffer == null) {
/* 071 */         // generate grouping key
/* 072 */         agg_holder.reset();
/* 073 */
/* 074 */         agg_rowWriter.zeroOutNullBytes();
/* 075 */
/* 076 */         if (inputadapter_isNull) {
/* 077 */           agg_rowWriter.setNullAt(0);
/* 078 */         } else {
/* 079 */           agg_rowWriter.write(0, inputadapter_value);
/* 080 */         }
/* 081 */
/* 082 */         if (inputadapter_isNull1) {
/* 083 */           agg_rowWriter.setNullAt(1);
/* 084 */         } else {
/* 085 */           agg_rowWriter.write(1, inputadapter_value1);
/* 086 */         }
/* 087 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 088 */         agg_value6 = 42;
/* 089 */
/* 090 */         if (!inputadapter_isNull) {
/* 091 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value6);
/* 092 */         }
/* 093 */
/* 094 */         if (!inputadapter_isNull1) {
/* 095 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value6);
/* 096 */         }
/* 097 */         if (true) {
/* 098 */           // try to get the buffer from hash map
/* 099 */           agg_unsafeRowAggBuffer =
/* 100 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 101 */         }
/* 102 */         if (agg_unsafeRowAggBuffer == null) {
/* 103 */           if (agg_sorter == null) {
/* 104 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 105 */           } else {
/* 106 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 107 */           }
/* 108 */
/* 109 */           // the hash map had be spilled, it should have enough memory now,
/* 110 */           // try  to allocate buffer again.
/* 111 */           agg_unsafeRowAggBuffer =
/* 112 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 113 */           if (agg_unsafeRowAggBuffer == null) {
/* 114 */             // failed to allocate the first page
/* 115 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 116 */           }
/* 117 */         }
/* 118 */       }
/* 119 */
/* 120 */       if (agg_fastAggBuffer != null) {
/* 121 */         // update fast row
/* 122 */
/* 123 */       } else {
/* 124 */         // update unsafe row
/* 125 */
/* 126 */         // common sub-expressions
/* 127 */
/* 128 */         // evaluate aggregate function
/* 129 */         boolean agg_isNull9 = true;
/* 130 */         double agg_value10 = -1.0;
/* 131 */
/* 132 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 133 */         double agg_value12 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 134 */         boolean agg_isNull10 = agg_isNull11;
/* 135 */         double agg_value11 = agg_value12;
/* 136 */         if (agg_isNull10) {
/* 137 */           boolean agg_isNull12 = false;
/* 138 */           double agg_value13 = -1.0;
/* 139 */           if (!false) {
/* 140 */             agg_value13 = (double) 0;
/* 141 */           }
/* 142 */           if (!agg_isNull12) {
/* 143 */             agg_isNull10 = false;
/* 144 */             agg_value11 = agg_value13;
/* 145 */           }
/* 146 */         }
/* 147 */
/* 148 */         if (!inputadapter_isNull2) {
/* 149 */           agg_isNull9 = false; // resultCode could change nullability.
/* 150 */           agg_value10 = agg_value11 + inputadapter_value2;
/* 151 */
/* 152 */         }
/* 153 */         boolean agg_isNull8 = agg_isNull9;
/* 154 */         double agg_value9 = agg_value10;
/* 155 */         if (agg_isNull8) {
/* 156 */           boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 157 */           double agg_value16 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 158 */           if (!agg_isNull15) {
/* 159 */             agg_isNull8 = false;
/* 160 */             agg_value9 = agg_value16;
/* 161 */           }
/* 162 */         }
/* 163 */         // update unsafe row buffer
/* 164 */         if (!agg_isNull8) {
/* 165 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 166 */         } else {
/* 167 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 168 */         }
/* 169 */
/* 170 */       }
/* 171 */       if (shouldStop()) return;
/* 172 */     }
/* 173 */
/* 174 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 175 */   }
/* 176 */
/* 177 */   protected void processNext() throws java.io.IOException {
/* 178 */     if (!agg_initAgg) {
/* 179 */       agg_initAgg = true;
/* 180 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 181 */       agg_doAggregateWithKeys();
/* 182 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 183 */     }
/* 184 */
/* 185 */     // output the result
/* 186 */
/* 187 */     while (agg_mapIter.next()) {
/* 188 */       wholestagecodegen_numOutputRows.add(1);
/* 189 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 190 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 191 */
/* 192 */       boolean agg_isNull16 = agg_aggKey.isNullAt(0);
/* 193 */       UTF8String agg_value17 = agg_isNull16 ? null : (agg_aggKey.getUTF8String(0));
/* 194 */       boolean agg_isNull17 = agg_aggKey.isNullAt(1);
/* 195 */       int agg_value18 = agg_isNull17 ? -1 : (agg_aggKey.getInt(1));
/* 196 */       boolean agg_isNull18 = agg_aggBuffer.isNullAt(0);
/* 197 */       double agg_value19 = agg_isNull18 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 198 */
/* 199 */       agg_holder1.reset();
/* 200 */
/* 201 */       agg_rowWriter1.zeroOutNullBytes();
/* 202 */
/* 203 */       if (agg_isNull17) {
/* 204 */         agg_rowWriter1.setNullAt(0);
/* 205 */       } else {
/* 206 */         agg_rowWriter1.write(0, agg_value18);
/* 207 */       }
/* 208 */
/* 209 */       if (agg_isNull16) {
/* 210 */         agg_rowWriter1.setNullAt(1);
/* 211 */       } else {
/* 212 */         agg_rowWriter1.write(1, agg_value17);
/* 213 */       }
/* 214 */
/* 215 */       if (agg_isNull18) {
/* 216 */         agg_rowWriter1.setNullAt(2);
/* 217 */       } else {
/* 218 */         agg_rowWriter1.write(2, agg_value19);
/* 219 */       }
/* 220 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 221 */       append(agg_result1);
/* 222 */
/* 223 */       if (shouldStop()) return;
/* 224 */     }
/* 225 */
/* 226 */     agg_mapIter.close();
/* 227 */     if (agg_sorter == null) {
/* 228 */       agg_hashMap.free();
/* 229 */     }
/* 230 */   }
/* 231 */ }
