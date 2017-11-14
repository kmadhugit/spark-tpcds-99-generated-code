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
/* 012 */   private long agg_bufValue1;
/* 013 */   private scala.collection.Iterator inputadapter_input;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 016 */   private UnsafeRow agg_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 019 */
/* 020 */   public GeneratedIterator(Object[] references) {
/* 021 */     this.references = references;
/* 022 */   }
/* 023 */
/* 024 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 025 */     partitionIndex = index;
/* 026 */     this.inputs = inputs;
/* 027 */     agg_initAgg = false;
/* 028 */
/* 029 */     inputadapter_input = inputs[0];
/* 030 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 031 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 032 */     agg_result = new UnsafeRow(2);
/* 033 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 034 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 035 */
/* 036 */   }
/* 037 */
/* 038 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 039 */     // initialize aggregation buffer
/* 040 */     boolean agg_isNull = false;
/* 041 */     double agg_value = -1.0;
/* 042 */     if (!false) {
/* 043 */       agg_value = (double) 0;
/* 044 */     }
/* 045 */     agg_bufIsNull = agg_isNull;
/* 046 */     agg_bufValue = agg_value;
/* 047 */     agg_bufIsNull1 = false;
/* 048 */     agg_bufValue1 = 0L;
/* 049 */
/* 050 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 051 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 052 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 053 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 054 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 055 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 056 */
/* 057 */       // do aggregate
/* 058 */       // common sub-expressions
/* 059 */       boolean agg_isNull3 = true;
/* 060 */       double agg_value3 = -1.0;
/* 061 */
/* 062 */       boolean agg_isNull4 = inputadapter_isNull;
/* 063 */       double agg_value4 = -1.0;
/* 064 */       if (!inputadapter_isNull) {
/* 065 */         agg_value4 = (double) inputadapter_value;
/* 066 */       }
/* 067 */       if (!agg_isNull4) {
/* 068 */         if (!inputadapter_isNull1) {
/* 069 */           agg_isNull3 = false; // resultCode could change nullability.
/* 070 */           agg_value3 = agg_value4 * inputadapter_value1;
/* 071 */
/* 072 */         }
/* 073 */
/* 074 */       }
/* 075 */       // evaluate aggregate function
/* 076 */       boolean agg_isNull7 = true;
/* 077 */       double agg_value7 = -1.0;
/* 078 */
/* 079 */       if (!agg_bufIsNull) {
/* 080 */         boolean agg_isNull9 = agg_isNull3;
/* 081 */         double agg_value9 = agg_value3;
/* 082 */         if (agg_isNull9) {
/* 083 */           boolean agg_isNull10 = false;
/* 084 */           double agg_value10 = -1.0;
/* 085 */           if (!false) {
/* 086 */             agg_value10 = (double) 0;
/* 087 */           }
/* 088 */           if (!agg_isNull10) {
/* 089 */             agg_isNull9 = false;
/* 090 */             agg_value9 = agg_value10;
/* 091 */           }
/* 092 */         }
/* 093 */
/* 094 */         agg_isNull7 = false; // resultCode could change nullability.
/* 095 */         agg_value7 = agg_bufValue + agg_value9;
/* 096 */
/* 097 */       }
/* 098 */       boolean agg_isNull12 = false;
/* 099 */       long agg_value12 = -1L;
/* 100 */       if (!false && agg_isNull3) {
/* 101 */         agg_isNull12 = agg_bufIsNull1;
/* 102 */         agg_value12 = agg_bufValue1;
/* 103 */       } else {
/* 104 */         boolean agg_isNull15 = true;
/* 105 */         long agg_value15 = -1L;
/* 106 */
/* 107 */         if (!agg_bufIsNull1) {
/* 108 */           agg_isNull15 = false; // resultCode could change nullability.
/* 109 */           agg_value15 = agg_bufValue1 + 1L;
/* 110 */
/* 111 */         }
/* 112 */         agg_isNull12 = agg_isNull15;
/* 113 */         agg_value12 = agg_value15;
/* 114 */       }
/* 115 */       // update aggregation buffer
/* 116 */       agg_bufIsNull = agg_isNull7;
/* 117 */       agg_bufValue = agg_value7;
/* 118 */
/* 119 */       agg_bufIsNull1 = agg_isNull12;
/* 120 */       agg_bufValue1 = agg_value12;
/* 121 */       if (shouldStop()) return;
/* 122 */     }
/* 123 */
/* 124 */   }
/* 125 */
/* 126 */   protected void processNext() throws java.io.IOException {
/* 127 */     while (!agg_initAgg) {
/* 128 */       agg_initAgg = true;
/* 129 */       long agg_beforeAgg = System.nanoTime();
/* 130 */       agg_doAggregateWithoutKey();
/* 131 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 132 */
/* 133 */       // output the result
/* 134 */
/* 135 */       agg_numOutputRows.add(1);
/* 136 */       agg_rowWriter.zeroOutNullBytes();
/* 137 */
/* 138 */       if (agg_bufIsNull) {
/* 139 */         agg_rowWriter.setNullAt(0);
/* 140 */       } else {
/* 141 */         agg_rowWriter.write(0, agg_bufValue);
/* 142 */       }
/* 143 */
/* 144 */       if (agg_bufIsNull1) {
/* 145 */         agg_rowWriter.setNullAt(1);
/* 146 */       } else {
/* 147 */         agg_rowWriter.write(1, agg_bufValue1);
/* 148 */       }
/* 149 */       append(agg_result);
/* 150 */     }
/* 151 */   }
/* 152 */ }
