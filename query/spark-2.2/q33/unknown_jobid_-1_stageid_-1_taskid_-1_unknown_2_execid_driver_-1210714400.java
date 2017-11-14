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
/* 021 */   private int agg_value4;
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
/* 042 */     agg_result = new UnsafeRow(1);
/* 043 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 044 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 045 */
/* 046 */     agg_result1 = new UnsafeRow(2);
/* 047 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 048 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
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
/* 060 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 061 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 062 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 063 */
/* 064 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 065 */
/* 066 */       UnsafeRow agg_fastAggBuffer = null;
/* 067 */
/* 068 */       if (agg_fastAggBuffer == null) {
/* 069 */         // generate grouping key
/* 070 */         agg_rowWriter.zeroOutNullBytes();
/* 071 */
/* 072 */         if (inputadapter_isNull) {
/* 073 */           agg_rowWriter.setNullAt(0);
/* 074 */         } else {
/* 075 */           agg_rowWriter.write(0, inputadapter_value);
/* 076 */         }
/* 077 */         agg_value4 = 42;
/* 078 */
/* 079 */         if (!inputadapter_isNull) {
/* 080 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value4);
/* 081 */         }
/* 082 */         if (true) {
/* 083 */           // try to get the buffer from hash map
/* 084 */           agg_unsafeRowAggBuffer =
/* 085 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 086 */         }
/* 087 */         if (agg_unsafeRowAggBuffer == null) {
/* 088 */           if (agg_sorter == null) {
/* 089 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 090 */           } else {
/* 091 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 092 */           }
/* 093 */
/* 094 */           // the hash map had be spilled, it should have enough memory now,
/* 095 */           // try  to allocate buffer again.
/* 096 */           agg_unsafeRowAggBuffer =
/* 097 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 098 */           if (agg_unsafeRowAggBuffer == null) {
/* 099 */             // failed to allocate the first page
/* 100 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 101 */           }
/* 102 */         }
/* 103 */       }
/* 104 */
/* 105 */       if (agg_fastAggBuffer != null) {
/* 106 */         // update fast row
/* 107 */
/* 108 */       } else {
/* 109 */         // update unsafe row
/* 110 */
/* 111 */         // common sub-expressions
/* 112 */
/* 113 */         // evaluate aggregate function
/* 114 */         boolean agg_isNull6 = true;
/* 115 */         double agg_value7 = -1.0;
/* 116 */
/* 117 */         boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 118 */         double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 119 */         boolean agg_isNull7 = agg_isNull8;
/* 120 */         double agg_value8 = agg_value9;
/* 121 */         if (agg_isNull7) {
/* 122 */           boolean agg_isNull9 = false;
/* 123 */           double agg_value10 = -1.0;
/* 124 */           if (!false) {
/* 125 */             agg_value10 = (double) 0;
/* 126 */           }
/* 127 */           if (!agg_isNull9) {
/* 128 */             agg_isNull7 = false;
/* 129 */             agg_value8 = agg_value10;
/* 130 */           }
/* 131 */         }
/* 132 */
/* 133 */         if (!inputadapter_isNull1) {
/* 134 */           agg_isNull6 = false; // resultCode could change nullability.
/* 135 */           agg_value7 = agg_value8 + inputadapter_value1;
/* 136 */
/* 137 */         }
/* 138 */         boolean agg_isNull5 = agg_isNull6;
/* 139 */         double agg_value6 = agg_value7;
/* 140 */         if (agg_isNull5) {
/* 141 */           boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 142 */           double agg_value13 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 143 */           if (!agg_isNull12) {
/* 144 */             agg_isNull5 = false;
/* 145 */             agg_value6 = agg_value13;
/* 146 */           }
/* 147 */         }
/* 148 */         // update unsafe row buffer
/* 149 */         if (!agg_isNull5) {
/* 150 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 151 */         } else {
/* 152 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 153 */         }
/* 154 */
/* 155 */       }
/* 156 */       if (shouldStop()) return;
/* 157 */     }
/* 158 */
/* 159 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 160 */   }
/* 161 */
/* 162 */   protected void processNext() throws java.io.IOException {
/* 163 */     if (!agg_initAgg) {
/* 164 */       agg_initAgg = true;
/* 165 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 166 */       agg_doAggregateWithKeys();
/* 167 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 168 */     }
/* 169 */
/* 170 */     // output the result
/* 171 */
/* 172 */     while (agg_mapIter.next()) {
/* 173 */       wholestagecodegen_numOutputRows.add(1);
/* 174 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 175 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 176 */
/* 177 */       boolean agg_isNull13 = agg_aggKey.isNullAt(0);
/* 178 */       int agg_value14 = agg_isNull13 ? -1 : (agg_aggKey.getInt(0));
/* 179 */       boolean agg_isNull14 = agg_aggBuffer.isNullAt(0);
/* 180 */       double agg_value15 = agg_isNull14 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 181 */
/* 182 */       agg_rowWriter1.zeroOutNullBytes();
/* 183 */
/* 184 */       if (agg_isNull13) {
/* 185 */         agg_rowWriter1.setNullAt(0);
/* 186 */       } else {
/* 187 */         agg_rowWriter1.write(0, agg_value14);
/* 188 */       }
/* 189 */
/* 190 */       if (agg_isNull14) {
/* 191 */         agg_rowWriter1.setNullAt(1);
/* 192 */       } else {
/* 193 */         agg_rowWriter1.write(1, agg_value15);
/* 194 */       }
/* 195 */       append(agg_result1);
/* 196 */
/* 197 */       if (shouldStop()) return;
/* 198 */     }
/* 199 */
/* 200 */     agg_mapIter.close();
/* 201 */     if (agg_sorter == null) {
/* 202 */       agg_hashMap.free();
/* 203 */     }
/* 204 */   }
/* 205 */ }
